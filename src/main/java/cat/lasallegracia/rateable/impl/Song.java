package cat.lasallegracia.rateable.impl;

import cat.lasallegracia.data.LocalData;
import cat.lasallegracia.rateable.Rateable;
import lombok.Getter;
import lombok.Setter;
import se.michaelthelin.spotify.model_objects.specification.Track;

@Getter @Setter public class Song implements Rateable {
    private Track track;
    private int rating;
    private String comment;

    public Song(Track track) {
        this.track = track;
    }

    @Override public String getDisplay() {
        return track.getName() + " - " + track.getArtists()[0].getName();
    }

    @Override public void sendToData(LocalData localData) {
        localData.addSong(this);
    }

    @Override public String toString() {
        return "Song{" +
               ", rating=" + rating +
               ", comment='" + comment + '\'' +
               '}';
    }
}
