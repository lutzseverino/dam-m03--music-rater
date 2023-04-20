package cat.lasallegracia.windows;

import cat.lasallegracia.i18n.ResourceBundleManager;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.ActionListDialogBuilder;

import javax.inject.Inject;
import java.util.List;

public class HomeSelection extends BasicWindow {
    @Inject public HomeSelection(ResourceBundleManager language) {
        setHints(List.of(Hint.CENTERED));

        Panel panel = new Panel();
        panel.setLayoutManager(new LinearLayout(Direction.VERTICAL).setSpacing(2));
        panel.setLayoutData(LinearLayout.createLayoutData(LinearLayout.Alignment.Center));

        Label title = new Label(language.getString("home.title"));
        Component dialog = new ActionListDialogBuilder()
                .setDescription(language.getString("home.dialog.description"))
                .addAction("Option 1", () -> {
                    // Do something for Option 1
                })
                .addAction("Option 2", () -> {
                    // Do something for Option 2
                }).build().getComponent();

        panel.addComponent(title);
        panel.addComponent(dialog);

        setComponent(panel);
    }
}

