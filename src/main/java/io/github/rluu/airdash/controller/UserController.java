package io.github.rluu.airdash.controller;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.rluu.airdash.exception.ResourceNotFoundException;
import io.github.rluu.airdash.model.User;
import io.github.rluu.airdash.repository.UserRepository;

/*

// rluu: For now, don't include this stuff.  We probably don't want clients to
// be doing anything with with users.  I've kept this code here as an example so
// we can change it for any other API services that I might want.


@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@Valid @PathVariable(value="id") Long id) throws ResourceNotFoundException {
		User user = userRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("User not found for id: " + id));
		return ResponseEntity.ok().body(user);
	}
	

	@DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        User user = userRepository.findById(id)
		   .orElseThrow(() -> new ResourceNotFoundException("User not found for id: " + id));

        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
        user.setUpdateDttm(now);
        user.setDeleteDttm(now);
        user.setDeleteInd(Boolean.TRUE);
        userRepository.save(user);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
 */