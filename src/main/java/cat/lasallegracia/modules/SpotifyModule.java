package cat.lasallegracia.modules;

import cat.lasallegracia.spotify.ReadOnlySpotifyService;
import cat.lasallegracia.spotify.SpotifyClientConfig;
import cat.lasallegracia.yaml.Snakelet;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.apache.hc.core5.http.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;

import java.io.IOException;

public class SpotifyModule extends AbstractModule {
    private static final Logger logger = LoggerFactory.getLogger(SpotifyModule.class);
    private final String configPath;


    public SpotifyModule(String configPath) {
        this.configPath = configPath;
    }

    @Provides public ReadOnlySpotifyService provideReadOnlySpotifyService() {
        SpotifyClientConfig spotifyClientConfig = new Snakelet(configPath).read(SpotifyClientConfig.class);

        if (spotifyClientConfig == null) {
            logger.error("Can't provide: Required file \"" + configPath + "\" is either missing or malformed. Program will exit.");
            System.exit(1);
        }

        System.out.println(spotifyClientConfig.getCLIENT_ID());

        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setClientId(spotifyClientConfig.getCLIENT_ID())
                .setClientSecret(spotifyClientConfig.getCLIENT_SECRET())
                .build();

        try {
            spotifyApi.setAccessToken(spotifyApi.clientCredentials().build().execute().getAccessToken());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new RuntimeException(e);
        }

        return new ReadOnlySpotifyService(spotifyApi);
    }
}
