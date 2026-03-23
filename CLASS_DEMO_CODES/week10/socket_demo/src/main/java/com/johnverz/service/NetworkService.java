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

    public List<Task> fetchAll(String path) {
        StringBuilder response = new StringBuilder();
        // fetching the data
        /*
         * socket
         * output stream - printwriter
         * input stream - bufferedreader
         */
        try (
                Socket door = new Socket(host, port);
                PrintWriter requestWriter = new PrintWriter(door.getOutputStream(), true);
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(door.getInputStream()));) {
            System.out.println("Voila! Connected to the server...");
            // send request to get the data
            // request header should contain: Method, Path, Protocol version, Host Header,
            // blank line
            requestWriter.println("GET " + path + " HTTP/1.0");
            requestWriter.println("Host: " + host);
            requestWriter.println("Connection: close");
            requestWriter.println(); // blank line ends the request header

            // process the response
            System.out.println("Processing response...");

            String line;
            boolean isBody = false;
            while ((line = responseReader.readLine()) != null) {
                if (line.isEmpty() && !isBody) {
                    isBody = true;
                    continue;
                }

                if (isBody) {
                    response.append(line);
                }
            }

        } catch (IOException e) {
            System.out.println("Cannot connect to the server. Sorry. Error: " + e.getMessage());
        }

        Gson gson = new Gson();
        Type taskType = new TypeToken<ArrayList<Task>>() {
        }.getType();
        List<Task> tasks = gson.fromJson(response.toString(), taskType);

        return tasks;
    }

    /**
     * This fetch a single task from path identified by id
     * 
     * @param path - the path of the resource
     * @param id   - the id of the record
     * @return Task record
     */
    public Task fetch(String path, int id) {
        StringBuilder response = new StringBuilder();
        // fetching the data
        /*
         * socket
         * output stream - printwriter
         * input stream - bufferedreader
         */
        try (
                Socket door = new Socket(host, port);
                PrintWriter requestWriter = new PrintWriter(door.getOutputStream(), true);
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(door.getInputStream()));) {
            System.out.println("Voila! Connected to the server...");
            // send request to get the data
            // request header should contain: Method, Path, Protocol version, Host Header,
            // blank line
            requestWriter.println("GET " + path + "/" + id + " HTTP/1.1");
            requestWriter.println("Host: " + host);
            requestWriter.println("Connection: close");
            requestWriter.println(); // blank line ends the request header

            // process the response
            System.out.println("Processing response...");

            String line;
            boolean isBody = false;
            while ((line = responseReader.readLine()) != null) {
                if (line.isEmpty() && !isBody) {
                    isBody = true;
                    continue;
                }

                if (isBody) {
                    response.append(line);
                }
            }

        } catch (IOException e) {
            System.out.println("Cannot connect to the server. Sorry. Error: " + e.getMessage());
        }

        Gson gson = new Gson();
        Task task = gson.fromJson(response.toString(), Task.class);

        return task;
    }

    /**
     * This method sends a new task to the server using an HTTP POST request.
     * It is used to create new resources on the server.
     *
     * @param path - the path of the resource (e.g., "/tasks")
     * @param task - the Task object to be sent and created
     * @return boolean - true if the request was successful, false otherwise
     */
    public boolean send(String path, Task task) {
        // Step 1: Convert the Task object into a JSON string
        // We use Gson to serialize the Java object into a format the server
        // understands.
        Gson gson = new Gson();
        String jsonPayload = gson.toJson(task);

        // We will store the server's response here
        StringBuilder response = new StringBuilder();

        // Step 2: Establish the network connection
        /*
         * We use a try-with-resources block to automatically close these resources when
         * done.
         * - Socket: the connection pipe to the server
         * - PrintWriter: used to output/send data (our request) to the server
         * - BufferedReader: used to input/read data (the response) from the server
         */
        try (
                Socket door = new Socket(host, port);
                PrintWriter requestWriter = new PrintWriter(door.getOutputStream(), true);
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(door.getInputStream()));) {
            System.out.println("Voila! Connected to the server for sending data...");

            // Step 3: Construct and send the HTTP POST request headers
            // The request line specifies the METHOD (POST), the PATH, and the PROTOCOL
            // defined by HTTP standard
            requestWriter.println("POST " + path + " HTTP/1.1");

            // The Host header tells the server which host we want to talk to
            requestWriter.println("Host: " + host);

            // We tell the server what type of content we are sending (JSON data)
            requestWriter.println("Content-Type: application/json; charset=utf-8");

            // The server needs to know exactly how much data we are sending in the body
            requestWriter.println("Content-Length: " + jsonPayload.getBytes().length);

            // We ask the server to close the connection after responding
            requestWriter.println("Connection: close");

            // A BLANK LINE is REQUIRED to separate the header section from the body section
            requestWriter.println();

            // Step 4: Send the request body
            // This is the actual JSON data containing our Task details
            requestWriter.print(jsonPayload);
            requestWriter.flush(); // Ensure all data is pushed and sent immediately

            // Step 5: Process the server's response
            System.out.println("Processing response...");

            String line;
            boolean isBody = false;
            // Read the response from the server line by line
            while ((line = responseReader.readLine()) != null) {
                // If we hit an empty line and haven't started reading the body,
                // it means the headers are done and the body is exactly underneath it
                if (line.isEmpty() && !isBody) {
                    isBody = true;
                    continue;
                }

                // If we are past the headers, append the body content to our response string
                if (isBody) {
                    response.append(line);
                }
            }

            // Print the response from the server for debugging
            System.out.println("Server Response body: " + response.toString());

            // Assuming successful creation if no exception occurred
            return true;

        } catch (IOException e) {
            // Handle any network errors that might occur
            System.out.println("Cannot connect to the server or error sending data. Error: " + e.getMessage());
            return false;
        }
    }

}


/*
Connect using socket
create output stream from socket
create input stream

send request using the output stream
receive response using the input stream

*/