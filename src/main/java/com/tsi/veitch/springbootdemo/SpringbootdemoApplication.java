package com.tsi.veitch.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/")
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

	@GetMapping()
	public @ResponseBody
	ResponseEntity<Void> getRoot(){
		return ResponseEntity.ok().build();
	}


}
