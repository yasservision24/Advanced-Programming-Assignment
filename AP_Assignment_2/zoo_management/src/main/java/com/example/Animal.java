package com.example;

interface Animal  {
    void feed(int index);
    void readAbout(int index);
    void addAnimal(String name, String noise, String history);
    void modifyAnimal(int index, String newNoise, String newHistory);
    void removeAnimal(int index);
    void viewAnimals();
    void justview();
}
