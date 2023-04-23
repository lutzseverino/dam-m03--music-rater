package cat.lasallegracia.repositories.impl;

import cat.lasallegracia.repositories.ListRepository;
import cat.lasallegracia.spotify.ReadOnlySpotifyService;
import cat.lasallegracia.rateable.impl.Mixtape;

import java.util.ArrayList;
import java.util.List;

public class MixtapeRepository implements ListRepository<Mixtape> {
    private ReadOnlySpotifyService spotify;

    public MixtapeRepository(ReadOnlySpotifyService spotify) {
        this.spotify = spotify;
    }

    @Override public List<Mixtape> query(String query, int limit, int offset) {
        List<Mixtape> mixtapes = new ArrayList<>();

        spotify.searchAlbum(query, limit, offset).forEach(album -> mixtapes.add(new Mixtape(album)));

        return mixtapes;
    }
}
