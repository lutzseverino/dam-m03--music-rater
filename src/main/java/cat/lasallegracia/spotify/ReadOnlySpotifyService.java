package cat.lasallegracia.spotify;

import lombok.Getter;
import se.michaelthelin.spotify.SpotifyApi;

@Getter
public class ReadOnlySpotifyService {
    private final SpotifyClientConfig spotifyClientConfig;
    private final SpotifyApi spotifyApi;

    public ReadOnlySpotifyService(SpotifyClientConfig spotifyClientConfig) {
        this.spotifyClientConfig = spotifyClientConfig;
        this.spotifyApi = new SpotifyApi.Builder()
                .setClientId(spotifyClientConfig.getCLIENT_ID())
                .setClientSecret(spotifyClientConfig.getCLIENT_SECRET())
                .build();
    }
}
