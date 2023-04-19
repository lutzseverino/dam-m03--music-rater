package cat.lasallegracia.i18n;

import lombok.Setter;

import java.io.File;
import java.util.*;

public class ResourceBundleManager {
    private static final String FOLDER = "/i18n/";
    private static final String BUNDLE_NAME = "i18n.jsmr";
    @Setter private ResourceBundle bundle;

    public ResourceBundleManager(Locale language) {
        this.bundle = ResourceBundle.getBundle(BUNDLE_NAME, language);
    }

    public ResourceBundleManager() {
        this.bundle = ResourceBundle.getBundle(BUNDLE_NAME);
    }


    public ResourceBundle fetchBundle(Locale language) {
        return ResourceBundle.getBundle(BUNDLE_NAME, language);
    }

    public String getString(String key) {
        try {
            return bundle.getString(key);
        } catch (MissingResourceException e) {
            return "???" + key + "???";
        }
    }

    public ArrayList<String> getAvailableLanguages() {
        File languageFolder = new File(Objects.requireNonNull(this.getClass().getResource(FOLDER)).getPath());
        ArrayList<String> languages = new ArrayList<>();

        for (File file : Objects.requireNonNull(languageFolder.listFiles())) {
            if (!file.getName().matches(".*[a-z]{2}_[A-Z]{2}.*")) {
                languages.add("en_US");
                continue;
            }

            languages.add(file.getName().replaceAll("(bundle_)|(.properties)", ""));
        }

        return languages;
    }

    public boolean isLanguageAvailable(String languageCode) {
        return getAvailableLanguages().contains(languageCode);
    }
}
