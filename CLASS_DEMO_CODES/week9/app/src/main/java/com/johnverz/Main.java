package com.johnverz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.johnverz.model.Dog;

public class Main {
    public static void main(String[] args) throws IOException{
        // serializeMultipleJsonObject();
        // deserializeMultipleJsonObject();
        // serializeObjectToJson();
        // deserializeSingleObject();
    }


    /**
     * This demonstrates how to serialize multiple Java objects and save to `data/dogs2.json`
     * @throws IOException
     */
    public static void serializeMultipleJsonObject() throws IOException{
        List<Dog> dogs = new ArrayList<>();
        Dog d1 = new Dog("Luwi", "German Shepherd", 5, "Black");
        Dog d2 = new Dog("Scooby Jess", "Belgian waffles", 5, "Mink");

        dogs.add(d2);
        d1.setBreed(null);
        dogs.add(d1);

        //Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        FileWriter fr = new FileWriter("data/dogs2.json");
        gson.toJson(dogs, fr);
        fr.close();
    }

    /**
     * This load `data/dogs.json` and deserialize it into list of Dob objects
     * @throws IOException
     */
    public static void deserializeMultipleJsonObject() throws IOException{
       FileReader fr = new FileReader("data/dogs.json");

        //in reading a list of JSON objects, we need a TypeToken
        //result will be a List of objects in Java
        Type dogListType = new TypeToken<ArrayList<Dog>>(){}.getType();

        Gson gson = new Gson();
        List<Dog> dogs = gson.fromJson(fr, dogListType);

        dogs.forEach((dog)->{
            System.out.println(dog);
        });

        for(Dog dog : dogs){
            System.out.println(dog);
        }

        dogs.forEach(System.out::println);

        for(int i = 0; i< dogs.size(); i++){
            System.out.println(dogs.get(i));
        }
        
    }

    /**
     * This demonstrates serializing a single Java object to JSON and save it to `data/dogs.json`
     */
    public static void serializeObjectToJson(){
        Gson gson = new Gson();
       try (FileReader reader = new FileReader("data/dogs.json")) {
            // Define the type of collection we want to extract
            Type dogListType = new TypeToken<ArrayList<Dog>>(){}.getType();

            // Parse the JSON file directly into the ArrayList
            List<Dog> dogList = gson.fromJson(reader, dogListType);

            // Print the results
            dogList.forEach(System.out::println);
            
        } catch (IOException e) {
            System.err.println("Could not read the file: " + e.getMessage());
        }
    }

    /**
     * This demonstrates loading a JSON object from file and convert it to Java object
     */
    public static void deserializeSingleObject(){
        String json = "";
        try(Scanner sc = new Scanner(new File("data/dog.json"))){
            while (sc.hasNextLine()) {
                json += sc.nextLine();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
        Gson gson = new Gson();

        Dog dog = gson.fromJson(json, Dog.class);
        System.out.println("Hello dog!");
        System.out.println(dog.toString());
    }
}