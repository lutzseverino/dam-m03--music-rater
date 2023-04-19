package cat.lasallegracia.types;

import lombok.Getter;
import lombok.Setter;
import se.michaelthelin.spotify.model_objects.specification.Track;

@Getter
@Setter
public class Song {
    private Track track;
    private int rating; // 1 - 10
    private String comment;
    // TODO: Finish
}
