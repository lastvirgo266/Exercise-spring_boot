package remember.controller;


import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import lombok.extern.slf4j.Slf4j;
import remember.BO.KakaoAPI;
import remember.BO.KakaoLogin;
import remember.entity.UserEntity;
import remember.service.UserService;

@Slf4j
@RestController
public class RestApiController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/test", method= RequestMethod.GET)
	public ResponseEntity<?> Test() {
		log.info("Test");
		return  new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/test/create", method= RequestMethod.POST)
	public ResponseEntity<?> TestCreate(@RequestBody UserEntity user) throws Exception {
		userService.saveUser(user);
		log.info(user.toString());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/test/read/{id}", method= RequestMethod.GET)
	public ResponseEntity<?> TestRead(@PathVariable("id") int userId) throws Exception {
		UserEntity user = userService.selectUser(userId);
		
		if(user == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		log.info(user.toString());
		
		return new ResponseEntity<>(user, HttpStatus.OK);
		
	}
	
	
	
	

}
