package ProjectUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configLoader {
    private static Properties properties;

    public static void loadConfig(String env) {
        properties = new Properties();
        String path = "src/main/java/PropertyFile/config." + env + ".properties";
        try (FileInputStream fis = new FileInputStream(path)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("❌ Failed to load config file for env: " + env, e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

}

