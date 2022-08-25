package com.tsi.veitch.springbootdemo.language;

import javax.persistence.*;

@Entity
@Table(name="language")
public class Language {

    @Id
    @Column(name="language_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int languageId;

    //Attributes
    @Column(name="name")
    private String name;

    public int getLanguageId() {
        return languageId;
    }

    public Language(){}

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
