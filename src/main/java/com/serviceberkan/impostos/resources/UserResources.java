package com.serviceberkan.impostos.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.serviceberkan.impostos.domain.User;
import com.serviceberkan.impostos.dto.UserDTO;
import com.serviceberkan.impostos.exception.ObjNotFoundException;
import com.serviceberkan.impostos.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Optional<User>> findById(@PathVariable String id){
		Optional<User> user = service.findById(id);
		if(user.isEmpty() || user == null) {
			throw new ObjNotFoundException("Object not found");
		}
		
		return ResponseEntity.ok().body(user);
	}
	
	

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> Save(@RequestBody UserDTO objDTO){
		User obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		//return ID
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> Update(@RequestBody UserDTO obj, @PathVariable String id ){
		User objNew = service.fromDTO(obj);
		objNew.setId(id);
		service.update(objNew);
		return ResponseEntity.noContent().build();
	}

	
	
	
	

}
