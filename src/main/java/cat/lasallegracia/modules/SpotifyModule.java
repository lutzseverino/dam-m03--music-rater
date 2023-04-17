package cat.lasallegracia.modules;

import cat.lasallegracia.spotify.ReadOnlySpotifyService;
import cat.lasallegracia.spotify.SpotifyClientConfig;
import cat.lasallegracia.yaml.Snakelet;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.michaelthelin.spotify.SpotifyApi;

public class SpotifyModule extends AbstractModule {
    private static final Logger logger = LoggerFactory.getLogger(SpotifyModule.class);
    private final String configPath;


    public SpotifyModule(String configPath) {
        this.configPath = configPath;
    }

    @Provides public ReadOnlySpotifyService provideReadOnlySpotifyService() {
        SpotifyClientConfig spotifyClientConfig = new Snakelet(configPath).read(SpotifyClientConfig.class);

        if (spotifyClientConfig == null) {
            logger.error("Can't initialize: Can't read config file: \"" + configPath + "\", it's either missing or malformed.");
            System.exit(1);
        }

        return new ReadOnlySpotifyService(
                new SpotifyApi.Builder()
                        .setClientId(spotifyClientConfig.getCLIENT_ID())
                        .setClientSecret(spotifyClientConfig.getCLIENT_SECRET())
                        .build()
        );
    }
}
