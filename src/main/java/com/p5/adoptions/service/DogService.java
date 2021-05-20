package com.p5.adoptions.service;


import com.p5.adoptions.model.CatDTO;
import com.p5.adoptions.model.DogDTO;
import com.p5.adoptions.model.ListDTO;
import com.p5.adoptions.model.adapters.CatAdapter;
import com.p5.adoptions.model.adapters.DogAdapter;

import com.p5.adoptions.repository.dogs.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public void AddDog(DogDTO dog) {
        if (dog.getName() == null || dog.getPhotoUrl() == null) {
            throw new RuntimeException("Dogs need to have a name!");
        }

        dogRepository.save(DogAdapter.fromDto(dog));
    }

    public ListDTO<DogDTO> findAll() {
        List<DogDTO> dogs = DogAdapter.toListDto(dogRepository.findAll());

        return new ListDTO<DogDTO>((int) dogRepository.count(), dogs);
    }

    public DogDTO findDog(String name) {
        if (name == null || name == "") {
            throw new RuntimeException("Dog must have a name");
        }
        return DogAdapter.toDto(dogRepository.findDogByName(name));

    }

}
