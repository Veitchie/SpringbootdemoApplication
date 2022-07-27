package com.tsi.veitch.springbootdemo.category;

import com.tsi.veitch.springbootdemo.film.Film;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Integer> {


}
