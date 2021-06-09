package com.p5.adoptions.service;


import com.p5.adoptions.model.AnimalShelterDTO;
import com.p5.adoptions.model.adapters.AnimalShelterAdapter;
import com.p5.adoptions.model.validations.OnCreate;
import com.p5.adoptions.model.validations.OnUpdate;
import com.p5.adoptions.repository.animals.Animal;
import com.p5.adoptions.repository.animals.AnimalRepository;
import com.p5.adoptions.repository.shelter.AnimalShelter;
import com.p5.adoptions.repository.shelter.AnimalShelterRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class AnimalShelterService {

    private final AnimalShelterRepository animalShelterRepository;
    private final AnimalRepository animalRepository;

    public AnimalShelterService(AnimalShelterRepository animalShelterRepository, AnimalRepository animalRepository) {
        this.animalShelterRepository = animalShelterRepository;
        this.animalRepository = animalRepository;
    }

    public AnimalShelterDTO getShelter(Integer id) {
    return AnimalShelterAdapter.toDto(animalShelterRepository.getOne(id)) ;
    }

    @Validated(OnCreate.class)
    public AnimalShelterDTO createShelter(@Valid AnimalShelterDTO shelterDTO) {

        AnimalShelter animalShelter= AnimalShelterAdapter.fromDto(shelterDTO);

        return AnimalShelterAdapter.toDto(animalShelterRepository.save(animalShelter));
    }

    @Validated(OnUpdate.class)
    public AnimalShelterDTO updateShelter(@Valid AnimalShelterDTO shelterDTO) {

        animalShelterRepository.findById(shelterDTO.getId()).orElseThrow(()-> new RuntimeException(" Shelter-ul nu a fost gasit"));

       return AnimalShelterAdapter.toDto(animalShelterRepository.save(AnimalShelterAdapter.fromDto(shelterDTO)));
    }

    public List<AnimalShelterDTO> getAll() {
        return AnimalShelterAdapter.toDTOList(animalShelterRepository.findAll());
    }
}
