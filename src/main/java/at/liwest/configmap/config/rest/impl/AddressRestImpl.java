package at.liwest.configmap.config.rest.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import at.liwest.configmap.config.rest.api.AddressRest;
import at.liwest.configmap.config.rest.model.Address;

@ApplicationScoped
public class AddressRestImpl implements AddressRest {
	
	@Inject
	@ConfigProperty(name = "incognito.config.zipcode")
	private String zipCode;

	@Override
	public Address getAddress() {
		return new Address(zipCode, "Industriezeile 34", "Linz");
	}

}
