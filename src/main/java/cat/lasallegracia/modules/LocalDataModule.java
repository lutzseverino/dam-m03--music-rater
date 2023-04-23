package cat.lasallegracia.modules;

import cat.lasallegracia.data.LocalData;
import cat.lasallegracia.yaml.Snakelet;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class LocalDataModule extends AbstractModule {
    private final String path;

    public LocalDataModule(String path) {
        this.path = path;
    }

    @Provides public LocalData provideLocalData() {
        Snakelet snakelet = new Snakelet(path);
        LocalData localData = snakelet.read(LocalData.class);

        if (localData == null) {
            localData = new LocalData();
            snakelet.write(localData);
        }

        return localData;
    }
}
