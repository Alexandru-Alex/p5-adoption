package com.p5.adoptions.api.controllers;

import com.p5.adoptions.repository.dogs.Dog;
import com.p5.adoptions.service.DogService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("v1/dogs")
public class DogController {

    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public ResponseEntity<List<Dog>> getAllDogs()
    {
        List<Dog> dogs=dogService.findAll();
        return ResponseEntity.ok(dogs);
    }

    @PostMapping
    public void addDog(@RequestBody Dog dog)
    {
        dogService.AddDog(dog);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Dog> findDogByName(@PathVariable("name")String name)
    {
        return ResponseEntity.ok(dogService.findDog(name));
    }


}
