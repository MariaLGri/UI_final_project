package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfig {
    private static final Properties properties = new Properties();
    private static final String DEFAULT_PROPERTIES_FILE = "test.properties";
    private static final String LOCAL_PROPERTIES_FILE = "local.properties";
    private static boolean isLocalRun = false;

    static {
        loadProperties();
    }

    private static void loadProperties() {
        // Проверяем, не локальный ли это запуск
        isLocalRun = Boolean.parseBoolean(System.getProperty("local", "false"));

        String propertiesFile = isLocalRun ? LOCAL_PROPERTIES_FILE : DEFAULT_PROPERTIES_FILE;

        try (InputStream input = TestConfig.class.getClassLoader().getResourceAsStream(propertiesFile)) {
            if (input == null) {
                throw new RuntimeException("Unable to find " + propertiesFile);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file", e);
        }
    }

    public static String getBaseUrl() {
        return getProperty("base.url");
    }

    public static String getBrowser() {
        return getProperty("browser");
    }

    public static String getBrowserVersion() {
        return getProperty("browser.version");
    }

    public static String getBrowserSize() {
        return getProperty("browser.size");
    }

    public static String getSelenoidUserLogin() {
        return getProperty("selenoid.user.login");
    }

    public static String getSelenoidUserPassword() {
        return getProperty("selenoid.user.password");
    }

    public static String getSelenoidUrl() {
        return getProperty("selenoid.url");
    }

    public static String getPageLoadStrategy() {
        return getProperty("page.load.strategy");
    }

    public static long getTimeout() {
        return Long.parseLong(getProperty("timeout"));
    }

    public static String getReportsFolder() {
        return getProperty("reports.folder");
    }

    public static boolean isLocalRun() {
        return isLocalRun || Boolean.parseBoolean(getProperty("use.local.browser", "false"));
    }

    private static String getProperty(String key) {
        return getProperty(key, null);
    }

    private static String getProperty(String key, String defaultValue) {

        String value = System.getProperty(key);
        if (value != null) {
            return value;
        }

        return properties.getProperty(key, defaultValue);
    }
}