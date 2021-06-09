package com.p5.adoptions.model;

import com.p5.adoptions.model.validations.OnCreate;
import com.p5.adoptions.model.validations.OnUpdate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

public class AnimalShelterDTO
{
    @Null(message ="Id trebuie sa fie null la creare",groups = OnCreate.class)
    @NotNull(message = "Id trebuie sa nu fie null la creare",groups = OnUpdate.class)
    @Min(value = 1,groups = OnUpdate.class)
    private Integer id;

    @NotNull(message = "Numele este necesar")
    @NotBlank(message = "Numele trebuie sa aiba minim 3 caractere")
    private String name;
    @NotNull
    @NotBlank
    private String address;

    @NotNull
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
