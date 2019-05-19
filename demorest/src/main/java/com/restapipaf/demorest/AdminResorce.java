package com.restapipaf.demorest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("admins")
public class AdminResorce {

	AdminDAO repo = new AdminDAO();

	// GET client
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Admin> getAdmins() {
		System.out.println("getAdmin called...");

		return repo.getAdmins();
	}

	@GET
	@Path("admin/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Admin getAdmin(@PathParam("id") int id) {
		return repo.getAdmin(id);
	}

	// POST client
	@POST
	@Path("admin")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Admin createAdmin(Admin a1) {
		System.out.println(a1);
		repo.create(a1);

		return a1;
	}

	// UPDATE client
	@PUT
	@Path("admin")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Admin updateAdmin(Admin a1) {
		System.out.println(a1);
		if (repo.getAdmin(a1.getId()).getId() == 0) {
			repo.create(a1);
		} else {
			repo.update(a1);
		}

		return a1;
	}

	// DELETE Client
	@DELETE
	@Path("admin/{id}")
	public Admin killAdmin(@PathParam("id") int id) {
		Admin a = repo.getAdmin(id);

		if (a.getId() != 0)
			repo.delete(id);

		return a;
	}

}
