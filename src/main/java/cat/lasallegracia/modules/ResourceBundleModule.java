package cat.lasallegracia.modules;

import cat.lasallegracia.i18n.ResourceBundleManager;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import java.util.Locale;

public class ResourceBundleModule extends AbstractModule {
    @Provides
    public ResourceBundleManager resourceBundleManager() {
        Locale defaultLocale = Locale.getDefault();
        return new ResourceBundleManager(defaultLocale);
    }
}
