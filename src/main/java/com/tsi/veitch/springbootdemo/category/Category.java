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
    private int category_id;

    @JsonIgnore
    @ManyToMany(mappedBy = "categorySet")
    public Set<Film> films;

    //Attributes
    @Column(name="name")
    private String name;

    public Category(String name){
        this.name = name;
    }

    //Empty Constructor
    public Category(){}

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
