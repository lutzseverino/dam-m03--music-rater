package cat.lasallegracia.spotify;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * This class is used to read the Spotify client configuration from the config.yaml file.
 * <p>
 * The @JsonProperty annotation is required to map the config file
 * keys to the class fields with proper casing.
 */
@Getter
@Setter
public class SpotifyClientConfig {
    @JsonProperty("CLIENT_ID") private String CLIENT_ID;
    @JsonProperty("CLIENT_SECRET") private String CLIENT_SECRET;
}
