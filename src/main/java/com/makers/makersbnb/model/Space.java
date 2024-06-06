package com.makers.makersbnb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SPACES")

public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String description;
    Double price;
    private String rules;

    public Space() {}

    public Space(String name, String description, Double price, String rules) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.rules = rules;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRules() {
        return this.rules = rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }


}
