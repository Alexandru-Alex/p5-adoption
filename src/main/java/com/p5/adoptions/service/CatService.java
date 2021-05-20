package com.p5.adoptions.service;


import com.p5.adoptions.model.CatDTO;
import com.p5.adoptions.model.ListDTO;
import com.p5.adoptions.model.adapters.CatAdapter;
import com.p5.adoptions.repository.cats.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    private final CatRepository catRepository;


    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public void addCat(CatDTO cat) {
        if (cat.getName() == null || cat.getPhotoUrl() == null) {
            throw new RuntimeException("Cat must have a name and a photo!");
        }
        catRepository.save(CatAdapter.fromDto(cat));
    }

    public ListDTO<CatDTO> findAll() {

        List<CatDTO> cats = CatAdapter.toListDto(catRepository.findAll());

        return new ListDTO<CatDTO>((int) catRepository.count(), cats);


    }

    public CatDTO findCat(String name) {
        if (name == null || name == "") {
            throw new RuntimeException("Must specify name!");
        }


        return CatAdapter.toDto(catRepository.findCatByName(name));
    }
}
