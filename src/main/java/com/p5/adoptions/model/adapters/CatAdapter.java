package com.p5.adoptions.model.adapters;

import com.p5.adoptions.model.CatDTO;
import com.p5.adoptions.repository.cats.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter {



    public static Cat fromDto(CatDTO cat)
    {
        return  new Cat().setName(cat.getName()).setUrl(cat.getPhotoUrl());
    }

    public static CatDTO toDto(Cat cat)
    {
        return new CatDTO(cat.getName(), cat.getUrl(),cat.getId());
    }


    public static List<CatDTO> toListDto(List<Cat> catList)
    {
        List<CatDTO> dtoList = new ArrayList<>();

        catList.forEach(cat -> dtoList.add(toDto(cat)));

        return dtoList;
    }


}