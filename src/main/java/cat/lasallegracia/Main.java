package cat.lasallegracia;

import cat.lasallegracia.modules.SpotifyModule;
import cat.lasallegracia.spotify.ReadOnlySpotifyService;
import cat.lasallegracia.spotify.SpotifyClientConfig;
import cat.lasallegracia.yaml.Snakelet;
import com.google.inject.Guice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Main {
    INSTANCE;
    private static final Logger logger = LoggerFactory.getLogger(Snakelet.class);


    public static void main(String[] args) {
        String configPath = args.length > 0 ? args[0] : "src/main/resources/config.yaml";
        SpotifyClientConfig spotifyClientConfig = new Snakelet(configPath).read(SpotifyClientConfig.class);

        if (spotifyClientConfig == null) {
            logger.error("Can't read config file: \"" + configPath + "\", it's either missing or malformed.");
            System.exit(1);
        }

        var injector = Guice.createInjector(new SpotifyModule(
                new ReadOnlySpotifyService(spotifyClientConfig))
        );
        JavaSimpleMusicRater instance = injector.getInstance(JavaSimpleMusicRater.class);

        instance.start();
    }
}