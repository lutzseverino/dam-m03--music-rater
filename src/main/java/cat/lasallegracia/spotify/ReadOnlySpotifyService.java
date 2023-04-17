package cat.lasallegracia.spotify;

import lombok.Getter;
import se.michaelthelin.spotify.SpotifyApi;

@Getter
public record ReadOnlySpotifyService(SpotifyApi spotifyApi) {

    // useful abstraction for utility methods?
}
