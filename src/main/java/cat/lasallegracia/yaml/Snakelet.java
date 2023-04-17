package cat.lasallegracia.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.jline.utils.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public record Snakelet(String path) {

    private static final Logger logger = LoggerFactory.getLogger(Snakelet.class);

    /**
     * @param clazz the class of the instance to be read
     * @param <T>   the object the file is representing
     * @return parsed object
     */
    public <T> T read(Class<T> clazz) {
        var mapper = new ObjectMapper(new YAMLFactory()).findAndRegisterModules();

        try {
            return mapper.readValue(new File(path), clazz);
        } catch (IOException e) {
            logger.error("Can't read or deserialize file: \"" + path + "\"");
        }

        return null;
    }

    /**
     * @param object the object to be written
     */
    public void write(Object object) {
        DumperOptions options = getDumperOptions();
        Yaml yaml = new Yaml(options);

        FileWriter writer = null;
        try {
            writer = new FileWriter(path);
        } catch (IOException e) {
            Log.error(this.getClass(), "Can't write file: \"" + path + "\"");
        }

        yaml.dump(object, writer);
    }

    private DumperOptions getDumperOptions() {
        DumperOptions options = new DumperOptions();
        options.setIndent(2);
        options.setPrettyFlow(true);
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

        return options;
    }
}
