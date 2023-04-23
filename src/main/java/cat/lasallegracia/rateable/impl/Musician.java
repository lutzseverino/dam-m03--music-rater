package cat.lasallegracia.rateable.impl;

import cat.lasallegracia.data.LocalData;
import cat.lasallegracia.rateable.Rateable;
import lombok.Getter;
import lombok.Setter;
import se.michaelthelin.spotify.model_objects.specification.Artist;

@Getter @Setter public class Musician implements Rateable {
    private Artist artist;
    private int rating;
    private String comment;

    public Musician(Artist artist) {
        this.artist = artist;
    }

    @Override public String getDisplay() {
        return artist.getName();
    }

    @Override public void sendToData(LocalData localData) {
        localData.addMusician(this);
    }

    @Override public String toString() {
        return "Musician{" +
               ", rating=" + rating +
               ", comment='" + comment + '\'' +
               '}';
    }
}
