package cat.lasallegracia.data;

import cat.lasallegracia.rateable.impl.Mixtape;
import cat.lasallegracia.rateable.impl.Musician;
import cat.lasallegracia.rateable.impl.Song;
import cat.lasallegracia.yaml.Snakelet;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter public class LocalData {
    private final List<Song> songs;
    private final List<Musician> musicians;
    private final List<Mixtape> mixtapes;

    public LocalData() {
        songs = new ArrayList<>();
        musicians = new ArrayList<>();
        mixtapes = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void addMusician(Musician musician) {
        musicians.add(musician);
    }

    public void addMixtape(Mixtape mixtape) {
        mixtapes.add(mixtape);
    }

    public void save() {
        Snakelet snakelet = new Snakelet("src/main/resources/data.yaml");
        snakelet.write(this);
    }

    @Override public String toString() {
        return "LocalData{" +
               "songs=" + songs +
               ", musicians=" + musicians +
               ", mixtapes=" + mixtapes +
               '}';
    }
}
