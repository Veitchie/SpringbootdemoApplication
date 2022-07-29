package com.tsi.veitch.springbootdemo.film;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.tsi.veitch.springbootdemo.actor.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//@CrossOrigin(origins="*")
@RestController
@RequestMapping("/Sakila/film")
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;
    private Set<String> filterStrings = new HashSet<>();

    public FilmController(FilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }

    MappingJacksonValue applyFilter(Iterable<Film> films, Integer inAc){
        filterStrings.clear();
        if (inAc == null){
            filterStrings.add("actorSet");
        }else if (inAc != 1){filterStrings.add("actorSet");}

        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.serializeAllExcept(filterStrings);

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("filmResponseFilter", simpleBeanPropertyFilter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(films);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }

    // Return ALL films
    @GetMapping()
    public @ResponseBody
    MappingJacksonValue getAllFilms(@RequestParam(name = "id", required = false) Integer id, @RequestParam(name = "includeActors", required = false) Integer inAc){
        if (id != null){
            //return filmRepository.findByFilmId(id);
            return applyFilter(filmRepository.findByFilmId(id), inAc);
        }
        //return filmRepository.findAll();
        return applyFilter(filmRepository.findAll(), inAc);
    }

    // Return the films without actorSet
    @GetMapping("/dynamic")
    MappingJacksonValue getAllFilms(){
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.serializeAllExcept("actorSet");

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("filmResponseFilter", simpleBeanPropertyFilter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(filmRepository.findAll());
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
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
        return filmRepository.findByFilmId(id).iterator().next().getTitle();
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
        return filmRepository.findByFilmId(id).iterator().next().getActorSet();
    }

}
