package at.liwest.configmap.config.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wildfly.microprofile.config.PropertiesConfigSource;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Thomas Herzog <herzog.thomas81@gmail.com>
 * @since 4/8/18
 */
public class ConfigSource extends PropertiesConfigSource {

    private static URL URL_SSH_PROPERTIES;

    private static final String LOCAL_SSH_PROPERTIES_FILE = "local-config.properties";
    private static final String EXTERNAL_SSH_PROPERTIES_FILE = "/config/config.properties";
    private static final Logger LOG = LoggerFactory.getLogger(ConfigSource.class);

    static {
        try {
            if (Files.exists(Paths.get(EXTERNAL_SSH_PROPERTIES_FILE))) {
                LOG.info(String.format("External properties found at '%s'", EXTERNAL_SSH_PROPERTIES_FILE));
                URL_SSH_PROPERTIES = Paths.get(EXTERNAL_SSH_PROPERTIES_FILE).toFile().toURI().toURL();
            } else {
                LOG.warn(String.format("No external properties found at '%s' falling back to '%s'", EXTERNAL_SSH_PROPERTIES_FILE, LOCAL_SSH_PROPERTIES_FILE));
                URL_SSH_PROPERTIES = ClassLoader.getSystemResource(LOCAL_SSH_PROPERTIES_FILE).toURI().toURL();
                LOG.info(URL_SSH_PROPERTIES.getFile());
            }
        } catch (Throwable e) {
            throw new IllegalStateException("SSHConfigSource could not initialize its static context", e);
        }
    }

    public ConfigSource() throws IOException {
        super(URL_SSH_PROPERTIES);
    }
}
