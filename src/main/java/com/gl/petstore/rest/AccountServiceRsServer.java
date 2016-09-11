package com.gl.petstore.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.gl.petstore.rest.service.AccountService;
import com.gl.petstore.rest.service.impl.AccountServiceImpl;

public class AccountServiceRsServer {
	
	public AccountServiceRsServer(){
		JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
		sf.setResourceClasses(AccountService.class);
		sf.setResourceProvider(AccountService.class, new SingletonResourceProvider(new AccountServiceImpl()));
		
		List<Object> providers = new ArrayList<Object>();
//		providers.add(new JSONProvider<ArrayList<Account>>());
		providers.add(new JacksonJsonProvider());
		
		sf.setProviders(providers);
		
		sf.setAddress("http://localhost:9009");
		Server s = sf.create();
//		s.start();
	}

	public static void main(String[] args) {
		AccountServiceRsServer server = new AccountServiceRsServer();
		System.out.println("server is ready...");
		
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
