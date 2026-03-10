package com.johnverz.model;

import com.google.gson.annotations.SerializedName;

/**
 * This class is used to represent a Dog object
 * @author John Verz
 */
public class Dog {
    //@SerializedName("Name")
    private String name;
    public String getName() {
        return name;
    }
    /**
     * This method sets value for name property
     * @param name - The value to set the name to
     */
    public void setName(String name) {
        this.name = name;
    }
    private String breed;
    private int age;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    private String color;
    public Dog(){

    }
    public Dog(String name, String breed, int age, String color) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.color = color;
    }
    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    /**
     * This overrides the method toString() to return a user-friendly object representation
     * @return the user-friendly string format of the object
     */
    @Override
    public String toString(){
        return String.format("""
                Name: %s
                Breed: %s
                Age: %d
                Color: %s
                """, name, breed, age, color);
    }
    
}
