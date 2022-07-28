package com.tsi.veitch.springbootdemo.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins="*")
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

    // Update actors roll in a film, given the actor and film id
//    @PostMapping("/updateRoll")
//    public @ResponseBody
//    void updateActorRoll(@RequestParam int actor_id, @RequestParam int film_id){
//        actorRepository.updateRoll(actor_id, film_id);
//    }

    // Create a new actor with the given ActorDTO
    @PostMapping("/newActor")
    public @ResponseBody
    Actor createActor(@RequestParam String firstName, @RequestParam String lastName) {
        return actorRepository.save(new Actor(firstName,lastName));
    }

    // Update actor name
    @PatchMapping("/updateName")
    public @ResponseBody Actor updateActorById(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
        Actor actor = actorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No user exists with that id."));
        actor.update(firstName, lastName);
        return actorRepository.save(actor);
    }

}
