package com.tsi.veitch.springbootdemo.actor;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/Sakila/actor")
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    public ActorController(ActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }


    // Return ALL actors or a specific actor if an ID is given
    @GetMapping()
    public @ResponseBody
    Iterable<Actor>getAllActors(@RequestParam(name = "id", required = false) Integer id ){
        if (id != null){
            return actorRepository.findByActorId(id);
        }
        return actorRepository.findAll();
    }

    @GetMapping("/getFilms")
    public @ResponseBody
    MappingJacksonValue getBodyOfWork(@RequestParam Integer id){

        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.serializeAllExcept();

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("filmResponseFilter", simpleBeanPropertyFilter);

        MappingJacksonValue mappingJacksonValue = null;
        Optional<Actor> actors = actorRepository.findById(id);

        if (actors.isPresent()){
            mappingJacksonValue = new MappingJacksonValue(actors.get().films);
            mappingJacksonValue.setFilters(filterProvider);
        }

        return mappingJacksonValue;
    }

    @GetMapping("/search")
    public @ResponseBody
    Iterable<Actor> searchName(@RequestParam String query){
        return actorRepository.findByFullNameContainingIgnoreCase(query);
    }

    // Create a new actor with the given ActorDTO
    @PostMapping("/newActor")
    public @ResponseBody
    Actor createActor(@RequestParam String firstName, @RequestParam String lastName) {
        return actorRepository.save(new Actor(firstName,lastName));
    }

    @PostMapping("/newActorDTO")
    public @ResponseBody
    Actor createActorDTO(@RequestBody ActorDTO actorDTO) {
        return actorRepository.save(new Actor(actorDTO));
    }

    // Update actor name
    @PatchMapping("/updateName")
    public @ResponseBody Actor updateActorById(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
        Actor actor = actorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No user exists with that id."));
        actor.update(firstName, lastName);
        return actorRepository.save(actor);
    }

    // Delete an actor given an ID
    @DeleteMapping("/removeActor")
    public void deleteActorById(@RequestParam int id) {
        actorRepository.deleteById(id);
    }

}
