package at.liwest.configmap.config.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import at.liwest.configmap.config.rest.model.Address;


@Path("/")
public interface AddressRest {
	
	@GET
	@Path("address")
	@Produces("application/json")
	Address getAddress();
}
