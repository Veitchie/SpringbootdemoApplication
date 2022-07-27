package com.tsi.veitch.springbootdemo;

import com.tsi.veitch.springbootdemo.actor.Actor;
import com.tsi.veitch.springbootdemo.actor.ActorRepository;
import com.tsi.veitch.springbootdemo.film.Film;
import com.tsi.veitch.springbootdemo.film.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}


}
