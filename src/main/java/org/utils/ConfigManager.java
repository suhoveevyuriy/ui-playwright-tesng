package org.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static final Properties properties = new Properties();

    static {
        try {
            FileInputStream file =
                    new FileInputStream("src/test/resources/config.properties");

            properties.load(file);

        } catch (IOException e) {
            throw new RuntimeException("Cannot load config.properties");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}