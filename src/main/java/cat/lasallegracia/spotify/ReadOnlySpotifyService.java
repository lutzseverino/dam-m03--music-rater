package cat.lasallegracia.spotify;

import lombok.Getter;
import se.michaelthelin.spotify.SpotifyApi;

@Getter
public class ReadOnlySpotifyService {
    private final SpotifyApi spotifyApi;

    public ReadOnlySpotifyService(SpotifyApi spotifyApi) {
        this.spotifyApi = spotifyApi;
    }

    // useful abstraction for utility methods?
}
