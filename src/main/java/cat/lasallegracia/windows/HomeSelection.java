package cat.lasallegracia.windows;

import cat.lasallegracia.i18n.ResourceBundleManager;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.ActionListDialogBuilder;

import javax.inject.Inject;
import java.util.List;

public class HomeSelection extends BasicWindow {

    @Inject public HomeSelection(ResourceBundleManager language) {
        final LayoutData CENTERED_LAYOUT = LinearLayout.createLayoutData(LinearLayout.Alignment.Center);

        setHints(List.of(Hint.CENTERED));

        Panel panel = new Panel();
        panel.setLayoutManager(new LinearLayout(Direction.VERTICAL).setSpacing(2));

        Label title = new Label(language.getString("info.title"));
        title.setLayoutData(CENTERED_LAYOUT);

        Label about = new Label(language.getString("info.about"));
        about.setLayoutData(CENTERED_LAYOUT);

        Component dialog = new ActionListDialogBuilder()
                .setDescription(language.getString("home.dialog.description"))
                .addAction("Option 1", () -> {
                    // Do something for Option 1
                })
                .addAction("Option 2", () -> {
                    // Do something for Option 2
                }).build().getComponent();
        dialog.setLayoutData(CENTERED_LAYOUT);

        panel.addComponent(title);
        panel.addComponent(about);
        panel.addComponent(dialog);

        setComponent(panel);
    }
}

