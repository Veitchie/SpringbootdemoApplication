package com.tsi.veitch.springbootdemo.film;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tsi.veitch.springbootdemo.actor.Actor;
import com.tsi.veitch.springbootdemo.category.Category;
import com.tsi.veitch.springbootdemo.language.Language;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="film")
@JsonFilter("filmResponseFilter")
public class Film {

    @Id
    @Column(name="film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmId;

    //Attributes
    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description = null;
    @Column(name="releaseYear")
    private Date releaseYear = null;
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;
    @JsonIgnore
    @Column(name="originalLanguageId")
    private Integer originalLanguageId = null;
    @Column(name="rentalDuration")
    private Integer rentalDuration = 3;
    @Column(name="rentalRate")
    private Double rentalRate = 4.99;
    @Column(name="length")
    private Integer length = null;
    @Column(name="replacementCost")
    private Double replacementCost = 19.99;
    @Column(name="rating")
    private String rating = "G";
    @Column(name="specialFeatures")
    private String specialFeatures = null;

    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    public Set<Category> categorySet;

    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    public Set<Actor> actorSet;

    //Empty Constructor
    public Film(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public int getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(int originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public Double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(Double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(Double replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Set<Actor> getActorSet() {
        return actorSet;
    }

}
