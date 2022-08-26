package com.tsi.veitch.springbootdemo.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;



@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/Sakila/admin")
public class AdminController {

    @Autowired
    private ActorRepository actorRepository;

    public AdminController(ActorRepository actorRepository){
        this.actorRepository = actorRepository;
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
