package com.klimov.injectors;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The PropertyLoader class is responsible for loading properties from a configuration file.
 * @author s.a.klimov
 */
public class PropertyLoader {

    /**
     * Properties object to store key-value pairs from the configuration file.
     */
    private Properties properties;

    /**
     * Loads properties from the specified configuration file.
     *
     * @param path The path to the configuration file.
     * @throws IOException If an error occurs while loading the configuration file.
     */
    public void loadProperties(String path) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(path)) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            throw new IOException("Error loading properties from " + path, e);
        }
    }

    /**
     * Gets a property value by key.
     *
     * @param key The key of the property.
     * @return The value of the property or null if the property is not found.
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
