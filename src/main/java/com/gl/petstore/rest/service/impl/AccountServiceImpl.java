package com.gl.petstore.rest.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.gl.petstore.rest.service.AccountService;

import ik.am.jpetstore.domain.model.Account;

@Path("/account-service/")
@Produces("text/xml")
public class AccountServiceImpl implements AccountService {
	Map<String, Account> accounts = new HashMap<String, Account>();

	@GET
	@Path("/accounts")
	public List<Account> getAccounts() {
		List<Account> accountObjs = new ArrayList<Account>();
		accountObjs.addAll(accounts.values());
		Collections.sort(accountObjs, new Comparator<Account>(){

			@Override
			public int compare(Account o1, Account o2) {
				return o1.getUsername().compareToIgnoreCase(o2.getUsername());
			}
			
		});
		
		return Collections.unmodifiableList(accountObjs);
	}

	@GET
	@Path("/accounts/{username}/")
	public Account getAccountWithUsername(@PathParam("username") String username) {
		Account account = accounts.get(username);
		
		return account;
	}
	
	@POST
	@Path("/accounts/")
	public Response addAccount(Account account){
		String username = account.getUsername();
		if(accounts.containsKey(username)){
			return Response.status(Response.Status.CONFLICT).build();
		}
		
		accounts.put(username, account);
		return Response.ok().build();
	}
	
	@PUT
	@Path("/accounts/")
	public Response updateAccount(Account account){
		return null;
	}

}
