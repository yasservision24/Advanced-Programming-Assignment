package com.example;

import java.util.LinkedHashMap;
import java.util.Map;

public class Amphibian implements Animal {
    private LinkedHashMap<String, String[]> animalDetails;

    public Amphibian() {
        animalDetails = new LinkedHashMap<>();
        // Adding two hardcoded animals
        addAnimal("Frog", "Ribbit", "Lives in water and land");
        addAnimal("Salamander", "Hiss", "Cold-blooded creature");
    }

    @Override
    public void feed(int index) {
        if (index >= 0 && index < animalDetails.size()) {
            String name = getKeyAtIndex(index);
            String noise = animalDetails.get(name)[0];
            System.out.println(name + " makes noise: " + noise);
        } else {
            System.out.println("Invalid index. Please select a valid index from the list.");
        }
    }
    
    @Override
    public void readAbout(int index) {
        if (index >= 0 && index < animalDetails.size()) {
            String name = getKeyAtIndex(index);
            String history = animalDetails.get(name)[1];
            System.out.println("History of " + name + ": " + history);
        } else {
            System.out.println("Invalid index. Please select a valid index from the list.");
        }
    }
    
    

// Helper method to get the animal name at a specific index
private String getKeyAtIndex(int index) {
    String[] keys = animalDetails.keySet().toArray(new String[0]);
    return keys[index];
}


    @Override
    public void addAnimal(String name, String noise, String history) {
        String[] details = {noise, history};
        animalDetails.put(name, details);
    }

    @Override
    public void modifyAnimal(int index, String newNoise, String newHistory) {
        if (index >= 0 && index < animalDetails.size()) {
            String[] keys = animalDetails.keySet().toArray(new String[0]);
            String name = keys[index];
            String[] details = {newNoise, newHistory};
            animalDetails.put(name, details);
            System.out.println("Details for " + name + " modified successfully.");
        } else {
            System.out.println("Invalid index. Please select a valid index from the list.");
        }
    }
    

    @Override
    public void removeAnimal(int index) {
        if (animalDetails.size() > 2) {
            if (index >= 0 && index < animalDetails.size()) {
                String[] keys = animalDetails.keySet().toArray(new String[0]);
                String name = keys[index];
                animalDetails.remove(name);
                System.out.println(name + " removed from the animal list.");
            } else {
                System.out.println("Invalid index. Please select a valid index from the list.");
            }
        } else {
            System.out.println("There must be at least two animals of the type Amphibian.");
        }
    }
    

    @Override
    public void viewAnimals() {
    System.out.println("Amphibian:");
    int index=0;
    for (Map.Entry<String, String[]> entry : animalDetails.entrySet()) {
        String name = entry.getKey();
        String[] details = entry.getValue();
        System.out.print("Index: " + index);
        System.out.print(" Name: " + name);
        System.out.print(" Noise: " + details[0]);
        System.out.print(" History: " + details[1]);
        index++;
        System.out.println(); // Add an empty line for separation
    }
}

@Override
public void justview() {
System.out.println("Amphibian:");
int index=0;
for (Map.Entry<String, String[]> entry : animalDetails.entrySet()) {
    String name = entry.getKey();
    String[] details = entry.getValue();
    System.out.print("Index: " + index);
    System.out.print(" Name: " + name);
    
    index++;
    System.out.println(); // Add an empty line for separation
}
}

}


