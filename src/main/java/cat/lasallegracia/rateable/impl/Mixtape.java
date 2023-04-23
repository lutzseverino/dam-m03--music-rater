package cat.lasallegracia.rateable.impl;

import cat.lasallegracia.data.LocalData;
import cat.lasallegracia.rateable.Rateable;
import lombok.Getter;
import lombok.Setter;
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;

@Getter @Setter public class Mixtape implements Rateable {
    private AlbumSimplified album;
    private int rating;
    private String comment;

    public Mixtape(AlbumSimplified album) {
        this.album = album;
    }

    @Override public String getDisplay() {
        return album.getName() + " - " + album.getArtists()[0].getName();
    }

    @Override public void sendToData(LocalData localData) {
        localData.addMixtape(this);
    }

    @Override public String toString() {
        return "Mixtape{" +
               ", rating=" + rating +
               ", comment='" + comment + '\'' +
               '}';
    }
}
