package cat.lasallegracia.rateable;

import cat.lasallegracia.data.LocalData;

public interface Rateable {
    String getDisplay();
    int getRating();
    void setRating(int rating);
    String getComment();
    void setComment(String comment);
    void sendToData(LocalData localData);
}
