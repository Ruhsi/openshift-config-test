package at.liwest.configmap.config.rest.provider;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Collections;

/**
 * This class disables the CORS protection for JAX-RS.
 *
 * @author Thomas Herzog <herzog.thomas81@gmail.com>
 * @since 4/16/18
 */
@Provider
public class CorsResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().put(
                "Access-Control-Allow-Origin", Collections.singletonList("*"));
    }
}
