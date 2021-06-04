package com.p5.adoptions.repository.animals;


import com.p5.adoptions.repository.shelter.AnimalShelter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//Option 1
//@MappedSuperclass

//Option 2
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//Daca nu e specificata default este numele clasei
//@DiscriminatorColumn(name="name",discriminatorType = DiscriminatorType.STRING)

//Option 3
// O tabela pt fiecare tabela , va face join la tabele pentru a compune entitatea
//Drawback: complexitate si timp
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)

//Option 4
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Animal  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    protected String name;
    protected String photoUrl;


    //@OneToOne(mappedBy = "animal")
    //private AnimalShelter shelter;


    //Bidirectional
   // @ManyToOne
   // @JoinColumn(name = "shelter_id")
    //AnimalShelter shelter;

    //Bidirectional ManyToMany
    //@ManyToMany(mappedBy = "animals")
    //List<AnimalShelter> shelters=new ArrayList<>();

    public  Animal()
    {

    }


    public Integer getId() {
        return id;
    }

    public Animal setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public Animal setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }
}