package com.tsi.veitch.springbootdemo.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/Sakila")
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    public ActorController(ActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }

    // Return ALL actors
    @GetMapping("/All_Actors")
    public @ResponseBody
    Iterable<Actor>getAllActors(){
        return actorRepository.findAll();
    }

}
