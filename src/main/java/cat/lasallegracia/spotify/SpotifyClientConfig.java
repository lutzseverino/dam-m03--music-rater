package cat.lasallegracia.spotify;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpotifyClientConfig {
    @JsonProperty("CLIENT_ID")
    private String CLIENT_ID;
    @JsonProperty("CLIENT_SECRET")
    private String CLIENT_SECRET;
}
