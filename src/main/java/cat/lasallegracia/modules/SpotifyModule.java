package cat.lasallegracia.modules;

import cat.lasallegracia.spotify.ReadOnlySpotifyService;
import com.google.inject.AbstractModule;

public class SpotifyModule extends AbstractModule {
    private final ReadOnlySpotifyService readOnlySpotifyService;

    public SpotifyModule(ReadOnlySpotifyService readOnlySpotifyService) {
        this.readOnlySpotifyService = readOnlySpotifyService;
    }

    @Override
    protected void configure() {
        bind(ReadOnlySpotifyService.class).toInstance(readOnlySpotifyService);
    }
}
