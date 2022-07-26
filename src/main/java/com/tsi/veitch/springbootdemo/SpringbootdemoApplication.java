package com.tsi.veitch.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@SpringBootApplication
@RestController
@RequestMapping("/Sakila")
public class SpringbootdemoApplication {

	@Autowired
	private ActorRepository actorRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

	public SpringbootdemoApplication(ActorRepository actorRepository){
		this.actorRepository = actorRepository;
	}

	//@CrossOrigin("http://localhost:8080")
	@GetMapping("/get-test")
	public @ResponseBody
	String randomName(){
		return "Get is working";
	}

	//Get request / read function
	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}
}
