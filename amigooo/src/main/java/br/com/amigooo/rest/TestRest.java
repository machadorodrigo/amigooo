package br.com.amigooo.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.amigooo.dao.RoleImpl;
import br.com.amigooo.model.Role;

@Path("/helloworld")
public class TestRest {
	
	@GET
	@Path("role")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getString(String rolename){
		Role role = new Role();
		role.setName(rolename);
		role.setDescription(rolename+"Desc");
		
		RoleImpl roleImpl = new RoleImpl();
		role = roleImpl.save(role);
		
		return role.getDescription();
	}
}
