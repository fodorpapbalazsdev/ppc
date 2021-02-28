package fodorpapabalazsdev.ppc.service;

import org.springframework.stereotype.Service;

import javax.el.PropertyNotFoundException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Service
public class PropertiesServiceImpl {

    private static final String PROPERTIES_FILE = "application.properties";
    private static final String VERSION_PROPERTY = "application.version";

    final static Properties properties = new Properties();

    public static String getAppVersion() throws IOException {

        String version = getPropertyByName(VERSION_PROPERTY);

        if (version == null) {
            throw new PropertyNotFoundException("Property not found with name: " + VERSION_PROPERTY);
        }

        if (version.equals("")) {
            throw new IOException("Property with name: " + VERSION_PROPERTY + " is filled with empty string.");
        }

        return version;
    }

    private static String getPropertyByName(String propertyName) throws IOException {
        loadProperties();
        return properties.getProperty(propertyName);
    }

    private static void loadProperties() throws IOException {
        InputStream inputStream = PropertiesServiceImpl.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);

        if (inputStream == null) {
            throw new FileNotFoundException("File not found with name: " + PROPERTIES_FILE);
        }

        properties.load(inputStream);
    }
}
