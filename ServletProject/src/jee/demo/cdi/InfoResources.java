package jee.demo.cdi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RequestScoped
@Path("info")
public class InfoResources {

	@Inject
	private ApplicationData appData;

	@GET
	public String getInfo() {
		return appData.getInfo();
	}
}
