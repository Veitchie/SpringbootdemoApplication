package com.tsi.veitch.springbootdemo.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/Sakila")
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }

    // Return ALL films
    @GetMapping("/All_Films")
    public @ResponseBody
    Iterable<Film>getAllFilms(){
        return filmRepository.findAll();
    }

    // Return all films starring a particular actor, given the actor ID
    @GetMapping("/Get_films_from_actor_id")
    public @ResponseBody
    Iterable<Film>getFilmByActor(@RequestParam int id){
        return filmRepository.returnFilmByID(id);
    }

    // Return film title, given the film ID
    @GetMapping("/Get_title_from_id")
    public @ResponseBody
    Film getFilmById(@RequestParam int id){
        return filmRepository.findByFilmId(id);
        //return filmRepository.getFilmFromID(id);
    }

    // Return the ID of a film, given the title
    @GetMapping("/Get_id_from_title")
    public @ResponseBody
    String getTitleByID(@RequestParam String title){
        return filmRepository.getIdFromTitle(title);
    }

    // Return all films that match the category, given the ID
    @GetMapping("/Get_films_from_cat")
    public @ResponseBody
    Iterable<Film> getFilmsByCat(@RequestParam int id){
        return filmRepository.getFilmFromCat(id);
    }
}
