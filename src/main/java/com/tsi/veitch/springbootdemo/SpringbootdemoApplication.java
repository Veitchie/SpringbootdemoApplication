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
	private FilmRepository filmRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

	public SpringbootdemoApplication(ActorRepository actorRepository, FilmRepository filmRepository){
		this.actorRepository = actorRepository;
		this.filmRepository = filmRepository;
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

	@GetMapping("/All_Films")
	public @ResponseBody
	Iterable<Film>getAllFilms(){
		return filmRepository.findAll();
	}

//	@GetMapping("/Get_actors_from_film_id")
//	public @ResponseBody
//	void deleteActorById(@RequestParam int id){
//		filmRepository.returnActorsByID(id);
//	}

	@GetMapping("/Get_title_from_id")
	public @ResponseBody
	Iterable<Film>getFilmById(@RequestParam int id){
		return filmRepository.getFilmFromID(id);
	}

	@GetMapping("/Get_id_from_title")
	public @ResponseBody
	String getTitleByID(@RequestParam String title){
		return filmRepository.getIdFromTitle(title);
	}
}
