package com.example.zoo_management;
public abstract class AnimalNamesHolder implements AnimalInterface {
    protected String[] animalNames;

    public AnimalNamesHolder(String[] names) {
        this.animalNames = names;
    }
}