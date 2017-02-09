package com.epam.library.config;

import java.util.ResourceBundle;

public class PropertyReader {
    private static final ResourceBundle bundle = ResourceBundle.getBundle("properties.database");

    private PropertyReader() {

    }

    public static String getProperty(String key) {

        return bundle.getString(key);
    }
}