package com.gl.petstore.rest;

import java.io.IOException;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

import com.gl.petstore.rest.service.AccountService;
import com.gl.petstore.rest.service.impl.AccountServiceImpl;

public class AccountServiceRsServer {
	
	public AccountServiceRsServer(){
		JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
		sf.setResourceClasses(AccountService.class);
		sf.setResourceProvider(AccountService.class, new SingletonResourceProvider(new AccountServiceImpl()));
		
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
