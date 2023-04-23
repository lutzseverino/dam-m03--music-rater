package cat.lasallegracia.repositories.impl;

import cat.lasallegracia.rateable.impl.Musician;
import cat.lasallegracia.rateable.impl.Song;
import cat.lasallegracia.repositories.ListRepository;
import cat.lasallegracia.spotify.ReadOnlySpotifyService;

import java.util.ArrayList;
import java.util.List;

public class SongRepository implements ListRepository<Song> {
    private ReadOnlySpotifyService spotify;

    public SongRepository(ReadOnlySpotifyService spotify) {
        this.spotify = spotify;
    }

    @Override public List<Song> query(String query, int limit, int offset) {
        List<Song> mixtapes = new ArrayList<>();

        spotify.searchTrack(query, limit, offset).forEach(track -> mixtapes.add(new Song(track)));

        return mixtapes;
    }
}
