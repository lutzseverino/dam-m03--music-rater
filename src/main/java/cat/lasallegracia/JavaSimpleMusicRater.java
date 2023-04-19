package cat.lasallegracia;

import cat.lasallegracia.i18n.ResourceBundleManager;
import com.google.inject.Inject;

public class JavaSimpleMusicRater {

    @Inject private ResourceBundleManager language;

    public void start() {
        System.out.println(language.getString("title"));
    }
}
