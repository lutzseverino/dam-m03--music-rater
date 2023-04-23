package cat.lasallegracia;

import cat.lasallegracia.components.AddFlow;
import cat.lasallegracia.components.Menu;
import cat.lasallegracia.data.LocalData;
import cat.lasallegracia.i18n.ResourceBundleManager;
import cat.lasallegracia.repositories.impl.MixtapeRepository;
import cat.lasallegracia.repositories.impl.MusicianRepository;
import cat.lasallegracia.repositories.impl.SongRepository;
import cat.lasallegracia.spotify.ReadOnlySpotifyService;

import javax.inject.Inject;

public class JavaSimpleMusicRater {

    @Inject private ResourceBundleManager lang;
    @Inject private ReadOnlySpotifyService spotify;
    @Inject private LocalData localData;


    public void start() {
        System.out.println(lang.getString("info.title"));


        AddFlow addFlow = new AddFlow(localData, lang);

        while (true) {
            new Menu(lang)
                    .addOption(lang.getString("main.rateArtist"), () -> addFlow.setListRepository(new MusicianRepository(spotify)).engage(new Menu(lang)))
                    .addOption(lang.getString("main.rateAlbum"), () -> addFlow.setListRepository(new MixtapeRepository(spotify)).engage(new Menu(lang)))
                    .addOption(lang.getString("main.rateSong"), () -> addFlow.setListRepository(new SongRepository(spotify)).engage(new Menu(lang)))
                    .addOption(lang.getString("main.seeData"), () -> {
                        localData.getSongs().forEach(System.out::println);
                        localData.getMixtapes().forEach(System.out::println);
                        localData.getMusicians().forEach(System.out::println);
                    })
                    .addOption(lang.getString("main.exit"), this::exit)
                    .engage();
        }
    }

    public void exit() {
        System.out.println(lang.getString("info.exiting"));
        System.exit(0);
    }
}
