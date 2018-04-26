package at.liwest.configmap.config.configuration;


import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author Thomas Herzog <herzog.thomas81@gmail.com>
 * @since 4/8/18
 */
@ApplicationPath("/rest-api")
@ApplicationScoped
public class RestApplication extends Application {
}
