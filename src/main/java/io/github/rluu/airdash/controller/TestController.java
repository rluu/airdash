package io.github.rluu.airdash.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("/userRoleMessage")
	public ResponseEntity<String> userRoleMessage() {
		return ResponseEntity.ok().body("Only visible to USER role owners!");
	}
	
	@GetMapping("/adminRoleMessage")
	public ResponseEntity<String> adminRoleMessage() {
		return ResponseEntity.ok().body("Only visible to ADMIN role owners!");
	}

}