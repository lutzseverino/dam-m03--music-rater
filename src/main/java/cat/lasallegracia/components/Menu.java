package cat.lasallegracia.components;

import cat.lasallegracia.i18n.ResourceBundleManager;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<MenuItem> options;
    private final ResourceBundleManager lang;
    private String title;

    public Menu(ResourceBundleManager lang) {
        this.lang = lang;
        options = new ArrayList<>();
    }

    public Menu setTitle(String title) {
        this.title = title;
        return this;
    }

    public Menu addOption(String option, Runnable action) {
        options.add(new MenuItem(option, action));
        return this;
    }

    public void show() {
        if (title != null) System.out.println(title);
        for (int i = 0; i < options.size(); i++) System.out.println((i + 1) + ". " + options.get(i).getOption());
    }

    public void engage() {
        show();

        var option = new Question(lang.getString("menu.error")).askInt(lang.getString("menu.choose"), i -> i > 0 && i <= options.size());

        options.get(option - 1).getAction().run();
    }

    public static class MenuItem {
        private final String option;
        private final Runnable action;

        public MenuItem(String option, Runnable action) {
            this.option = option;
            this.action = action;
        }

        public String getOption() {
            return option;
        }

        public Runnable getAction() {
            return action;
        }
    }
}
