package com.tsi.veitch.springbootdemo.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tsi.veitch.springbootdemo.film.Film;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="category")
public class Category {

    @Id
    @Column(name="category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @JsonIgnore
    @ManyToMany(mappedBy = "categorySet")
    public Set<Film> films;

    //Attributes
    @Column(name="name")
    private String name;

    //Empty Constructor
    public Category(){}

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
