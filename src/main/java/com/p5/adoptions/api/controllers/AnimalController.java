package com.p5.adoptions.api.controllers;


import com.p5.adoptions.model.AnimalDTO;
import com.p5.adoptions.repository.AnimalStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/animals")
public class AnimalController
{

    // @RequestMapping(method=RequestMethod.GET, value="/hello")  este varianta veche a lui @GetMapping("/hello")
    @GetMapping("/hello")
    public ResponseEntity<String> greetOwner(@RequestParam(name = "name",required = false)String ownerName)
    {
        String name= ownerName==null?"word":ownerName;
        return ResponseEntity.ok("Hello "+name+", from the animal shelter!");
    }

    @GetMapping
    public ResponseEntity<List<AnimalDTO>> getAvailableAnimals()
    {
        return ResponseEntity.ok(AnimalStore.available);
    }

    @PostMapping
    public ResponseEntity<AnimalDTO> addAnimalForAdoption(@RequestBody AnimalDTO animal)
    {
        if(animal==null&& animal.getName()==null&&  animal.getPhotoUrl()==null)
        {
         return ResponseEntity.badRequest().body(animal);
        }
        AnimalStore.available.add(animal);
        return ResponseEntity.ok(animal);
    }

    @PutMapping("/{name}")
    public void updateAnimal(@PathVariable(name="name")String name,@RequestBody AnimalDTO updatedAnimal)
    {
        List<AnimalDTO> available=AnimalStore.available;

        for(int i=0;i<available.size();i++)
        {
            AnimalDTO animal=available.get(i);
            if(animal.getName().equals(name))
            {
               available.remove(i);
               available.add(updatedAnimal);
               break;
            }
        }
    }

    @DeleteMapping("/{name}")
    public void deleteAnimal(@PathVariable(name="name")String name)
    {
        List<AnimalDTO> available=AnimalStore.available;

        for(int i=0;i<available.size();i++)
        {
            AnimalDTO animal=available.get(i);
            if(animal.getName().equals(name))
            {
                available.remove(i);
                break;
            }
        }
    }



}
