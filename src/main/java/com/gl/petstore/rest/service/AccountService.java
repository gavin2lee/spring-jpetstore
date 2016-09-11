package com.gl.petstore.rest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ik.am.jpetstore.domain.model.Account;

@Path("/account-service/")
@Produces("text/xml")
public interface AccountService {
	@GET
	@Path("/accounts")
	@Produces("application/json")
	List<Account> getAccounts();
	
	@GET
	@Path("/accounts/{username}/")
	@Produces("application/json")
	Account getAccountWithUsername(String username);
	
	@POST
	@Path("/accounts/")
	Response addAccount(Account account);
	
	@PUT
	@Path("/accounts/")
	Response updateAccount(Account account);
}
