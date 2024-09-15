package forms321.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties;

    public ConfigLoader() {
        properties = new Properties();
        try {
            // Load the properties file from the resources folder
            FileInputStream fileInput = new FileInputStream("src/test/resources/config.properties");
            properties.load(fileInput);
            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getChromeDriverPath() {
        return properties.getProperty("chrome.driver.path");
    }
    public String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }
    public String getOTP(){
        return properties.getProperty("signInCode");
    }

    // Method to get a string array from the properties file
    public static String[] getArrayProperty(String key) {
        String arrayAsString = properties.getProperty(key);
        if (arrayAsString != null) {
            return arrayAsString.split(",");
        } else {
            return new String[0]; // Return an empty array if the property is not found
        }
    }
}
