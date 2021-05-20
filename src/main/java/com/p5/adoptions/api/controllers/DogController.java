package com.p5.adoptions.api.controllers;

import com.p5.adoptions.model.DogDTO;
import com.p5.adoptions.model.ListDTO;
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
    public ResponseEntity<ListDTO<DogDTO>> getAllDogs()
    {

        return ResponseEntity.ok(dogService.findAll());
    }

    @PostMapping
    public void addDog(@RequestBody DogDTO dog)
    {
        dogService.AddDog(dog);
    }

    @GetMapping("/{name}")
    public ResponseEntity<DogDTO> findDogByName(@PathVariable("name")String name)
    {
        return ResponseEntity.ok(dogService.findDog(name));
    }


}
