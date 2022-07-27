package com.tsi.veitch.springbootdemo.category;

import com.tsi.veitch.springbootdemo.film.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/Sakila")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository filmRepository){
        this.categoryRepository = categoryRepository;
    }


}
