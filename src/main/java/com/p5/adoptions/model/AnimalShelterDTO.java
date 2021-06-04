package com.p5.adoptions.model;

import com.p5.adoptions.repository.animals.Animal;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class AnimalShelterDTO
{

    private Integer id;

    private String name;
    private String address;
    List<AnimalDTO> animals=new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public AnimalShelterDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AnimalShelterDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AnimalShelterDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<AnimalDTO> getAnimals() {
        return animals;
    }

    public AnimalShelterDTO setAnimals(List<AnimalDTO> animals) {
        this.animals = animals;
        return this;
    }
}