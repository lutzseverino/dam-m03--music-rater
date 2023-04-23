package cat.lasallegracia.repositories.impl;

import cat.lasallegracia.rateable.impl.Mixtape;
import cat.lasallegracia.rateable.impl.Musician;
import cat.lasallegracia.repositories.ListRepository;
import cat.lasallegracia.spotify.ReadOnlySpotifyService;

import java.util.ArrayList;
import java.util.List;

public class MusicianRepository implements ListRepository<Musician> {
    private ReadOnlySpotifyService spotify;

    public MusicianRepository(ReadOnlySpotifyService spotify) {
        this.spotify = spotify;
    }

    @Override public List<Musician> query(String query, int limit, int offset) {
        List<Musician> mixtapes = new ArrayList<>();

        spotify.searchArtist(query, limit, offset).forEach(artist -> mixtapes.add(new Musician(artist)));

        return mixtapes;
    }
}
