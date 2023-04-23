package cat.lasallegracia;

import cat.lasallegracia.modules.LocalDataModule;
import cat.lasallegracia.modules.ResourceBundleModule;
import cat.lasallegracia.modules.SpotifyModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public enum Main {
    INSTANCE;

    public static void main(String[] args) {
        String configPath = args.length > 0 ? args[0] : "src/main/resources/config.yaml";
        Injector injector = Guice.createInjector(
                new SpotifyModule(configPath),
                new LocalDataModule("src/main/resources/data.yaml"),
                new ResourceBundleModule()
        );
        JavaSimpleMusicRater instance = injector.getInstance(JavaSimpleMusicRater.class);

        instance.start();
    }

}