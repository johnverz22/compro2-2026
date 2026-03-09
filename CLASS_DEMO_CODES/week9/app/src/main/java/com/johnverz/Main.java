package com.johnverz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.johnverz.model.Dog;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String json = "";
        // json = """
        //          {
        //             "name":"Hades",
        //             "breed": "Aspin",
        //             "age": 4,
        //             "color": "Brown"
        //         }
        //         """;
            //String json2 = "{\"name\": \"Hades\", \"breed\": \"Aspin\", \"age\": 4, \"color\": \"White\"}";
            Scanner sc = new Scanner(new File("data/dog.json"));
            while(sc.hasNextLine()){
                json += sc.nextLine();
            }
            Gson gson = new Gson();
            Dog dog = gson.fromJson(json, Dog.class);

            dog.setName("Kai");

            System.out.println("Hello dog!");
            System.out.println(dog.toString());
    }
}