package com.tsi.veitch.springbootdemo.film;

import com.tsi.veitch.springbootdemo.actor.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/Sakila/film")
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
    String getFilmById(@RequestParam int id){
        return filmRepository.findByFilmId(id).getTitle();
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

    // Return the number of copies of a film in stock, given the ID
    @GetMapping("/Get_accurate_stock_from_id")
    public @ResponseBody
    int getStockFromID(@RequestParam int id){
        return filmRepository.getStockFromID(id);
    }

    // Return the actors in a film, given the ID
    @GetMapping("/Get_actors_from_id")
    public @ResponseBody
    Iterable<Actor> getActorsFromID(@RequestParam int id){
        return filmRepository.findByFilmId(id).getActorSet();
    }

}
