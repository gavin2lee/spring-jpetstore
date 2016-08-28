package ik.am.jpetstore.app.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ik.am.jpetstore.domain.model.Account;

@Controller
@RequestMapping("auth")
public class AuthController {
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);
	
	@RequestMapping(value="account",produces="application/json")
	@ResponseBody
	public Account getUserAccount(@RequestBody AuthForm af){
		log.debug(String.format("%s", af));
		
		Account a = new Account();
		a.setUsername(af.getUsername());
		a.setPassword(af.getPassword());
		
		a.setCountry("China");
		a.setCity("深圳");
		
		return a;
	}
}
