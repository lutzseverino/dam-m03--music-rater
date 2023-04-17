package cat.lasallegracia;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

public class JavaSimpleMusicRater {
    private final Terminal terminal;

    {
        try {
            terminal = TerminalBuilder.terminal();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


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

        terminal.writer().println(title);
    }
}
