package com.johnverz.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.johnverz.model.Task;

public class NetworkService {
    private String host;
    private int port;

    public NetworkService(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public List<Task> fetchAll(String path){
        StringBuilder response = new StringBuilder();
        //fetching the data
        /*
            socket
            output stream - printwriter
            input stream - bufferedreader
        */
        try(
            Socket door = new Socket(host, port);
            PrintWriter requestWriter = new PrintWriter(door.getOutputStream(), true);
            BufferedReader responseReader = new BufferedReader(new InputStreamReader(door.getInputStream()));
        ){
            System.out.println("Voila! Connected to the server...");
            //send request to get the data
            //request header should contain: Method, Path, Protocol version, Host Header, blank line
            requestWriter.println("GET " + path  + " HTTP/1.0");
            requestWriter.println("Host: " + host);
            requestWriter.println("Connection: close");
            requestWriter.println(); //blank line ends the request header

            //process the response
            System.out.println("Processing response...");

            String line;
            boolean isBody = false;
            while((line = responseReader.readLine()) !=null ){
                if(line.isEmpty() && !isBody){
                    isBody = true;
                    continue;
                }

                if(isBody){
                    response.append(line);
                }
            }
            

        }catch(IOException e){
            System.out.println("Cannot connect to the server. Sorry. Error: " + e.getMessage());
        }

        Gson gson = new Gson();
        Type taskType = new TypeToken<ArrayList<Task>>(){}.getType();
        System.out.println(response);
        List<Task> tasks = gson.fromJson(response.toString(), taskType);

        return tasks;
    }    


    /**
     * This fetch a single task from path identified by id
     * @param path - the path of the resource
     * @param id - the id of the record
     * @return Task record
     */
    public Task fetch(String path, int id){
        StringBuilder response = new StringBuilder();
        //fetching the data
        /*
            socket
            output stream - printwriter
            input stream - bufferedreader
        */
        try(
            Socket door = new Socket(host, port);
            PrintWriter requestWriter = new PrintWriter(door.getOutputStream(), true);
            BufferedReader responseReader = new BufferedReader(new InputStreamReader(door.getInputStream()));
        ){
            System.out.println("Voila! Connected to the server...");
            //send request to get the data
            //request header should contain: Method, Path, Protocol version, Host Header, blank line
            requestWriter.println("GET " + path + "/" + id + " HTTP/1.1");
            requestWriter.println("Host: " + host);
            requestWriter.println("Connection: close");
            requestWriter.println(); //blank line ends the request header

            //process the response
            System.out.println("Processing response...");

            String line;
            boolean isBody = false;
            while((line = responseReader.readLine()) !=null ){
                if(line.isEmpty() && !isBody){
                    isBody = true;
                    continue;
                }

                if(isBody){
                    response.append(line);
                }
            }
            

        }catch(IOException e){
            System.out.println("Cannot connect to the server. Sorry. Error: " + e.getMessage());
        }

        Gson gson = new Gson();
        Task task = gson.fromJson(response.toString(), Task.class);

        return task;
    }    
    

}
