package cat.lasallegracia;

import cat.lasallegracia.windows.HomeSelection;
import com.google.inject.Inject;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class JavaSimpleMusicRater {

    @Inject private HomeSelection homeSelection;

    public void start() {
        try {
            // TODO: Implement, this is just a test!
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);
            WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);

            screen.startScreen();
            textGUI.addWindow(homeSelection);
            homeSelection.waitUntilClosed();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
