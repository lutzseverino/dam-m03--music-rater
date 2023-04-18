package cat.lasallegracia.spotify;

import org.apache.hc.core5.http.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchTracksRequest;

import java.io.IOException;
import java.util.List;

public record ReadOnlySpotifyService(SpotifyApi spotifyApi) {
    private static final Logger logger = LoggerFactory.getLogger(ReadOnlySpotifyService.class);

    public List<Track> searchTrack(String trackName, int limit, int offset) {
        SearchTracksRequest searchTracksRequest = spotifyApi.searchTracks(trackName)
                .limit(limit)
                .offset(offset)
                .build();

        try {
            return List.of(searchTracksRequest.execute().getItems());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            logger.error(e.getMessage());
            return List.of();
        }
    }
}
