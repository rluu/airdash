package io.github.rluu.airdash.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = LogManager.getLogger(TestController.class);

	@GetMapping("/userRoleMessage")
	@PreAuthorize("hasAuthority('USER')")
	public ResponseEntity<String> userRoleMessage() {
	    logger.trace("Inside userRoleMessage()");
		return ResponseEntity.ok().body("Only visible to USER role owners!");
	}
	
	@GetMapping("/adminRoleMessage")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<String> adminRoleMessage() {
	    logger.trace("Inside adminRoleMessage()");
		return ResponseEntity.ok().body("Only visible to ADMIN role owners!");
	}

	@GetMapping("/allMessage")
	@PreAuthorize("permitAll()") 
	public ResponseEntity<String> allMessage() {
	    logger.trace("Inside allMessage()");
		return ResponseEntity.ok().body("Visible to everyone!");
	}

}