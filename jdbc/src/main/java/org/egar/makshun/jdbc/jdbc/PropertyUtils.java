package org.egar.makshun.jdbc.jdbc;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

class PropertyUtils {

    static Properties getProperties(String fileName) {

        Properties properties = new Properties();
        try {
            properties.load(
                    Objects.requireNonNull(
                            PropertyUtils.class.getClassLoader().getResourceAsStream(fileName)
                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
