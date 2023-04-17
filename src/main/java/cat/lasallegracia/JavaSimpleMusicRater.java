package cat.lasallegracia;

import cat.lasallegracia.spotify.ReadOnlySpotifyService;
import com.google.inject.Inject;

public class JavaSimpleMusicRater {

    @Inject private ReadOnlySpotifyService spotifyService;

    public void start() {
        String title = """
                                                          \s
                       _|    _|_|_|  _|      _|  _|_|_|   \s
                       _|  _|        _|_|  _|_|  _|    _| \s
                       _|    _|_|    _|  _|  _|  _|_|_|   \s
                 _|    _|        _|  _|      _|  _|    _| \s
                   _|_|    _|_|_|    _|      _|  _|    _| \s
                                                          \s
                """;

        System.out.println(title);

    }
}
