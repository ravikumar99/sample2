package com.journaldev.bootifulmongo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.bootifulmongo.User;
import com.journaldev.bootifulmongo.repository.UserRepository;

@RestController
@RequestMapping("/api")
@EnableMongoRepositories(basePackages = "com.journaldev.bootifulmongo.repository")
public class UserController {
	
	@Autowired
	private UserRepository repository;
		@GetMapping("/getfindById/{id}")
		public Optional<User> retriveData(@PathVariable String id) {
			return repository.findById(id);
		}
		
		@GetMapping("/getAllData")
		public List<User> retriveAllData(){
			return repository.findAll();
		}
		
		@GetMapping("/getfindByName/{name}")
		public User retriveCount(@PathVariable String name){
			return repository.findByName(name);
		}
		
		@PostMapping("/putdata")
		public User insertData(@RequestBody User user) {
			return repository.save(user);
		}
		
		@DeleteMapping("/deletedata/{id}")
		public void deleteData(@RequestParam User us) {
			 	repository.deleteById(us.getUserId());
		}
}

