package cat.lasallegracia.components;

import cat.lasallegracia.data.LocalData;
import cat.lasallegracia.i18n.ResourceBundleManager;
import cat.lasallegracia.rateable.Rateable;
import cat.lasallegracia.repositories.ListRepository;

import java.util.List;

public class AddFlow {
    private ListRepository<?> listRepository;
    private LocalData localData;
    private ResourceBundleManager lang;

    public AddFlow(LocalData localData, ResourceBundleManager lang) {
        this.localData = localData;
        this.lang = lang;
    }

    public AddFlow setListRepository(ListRepository<?> listRepository) {
        this.listRepository = listRepository;
        return this;
    }

    public void engage(Menu menu) {
        String query = new Question("general.error").ask(lang.getString("addFlow.search"));

        System.out.println(lang.getString("addFlow.searching"));

        List<? extends Rateable> rateables = listRepository.query(query, 5, 0);

        rateables.forEach(rateable -> menu.addOption(rateable.getDisplay(), () -> rate(rateable)));
        menu.engage();
    }

    public void rate(Rateable rateable) {
        int rating = new Question("general.error").askInt(lang.getString("addFlow.rate"), i -> i >= 0 && i <= 10);
        String comment = new Question("general.error").ask(lang.getString("addFlow.comment"));

        rateable.setRating(rating);
        rateable.setComment(comment);

        rateable.sendToData(localData);
        System.out.println(localData);
        localData.save();
    }

}
