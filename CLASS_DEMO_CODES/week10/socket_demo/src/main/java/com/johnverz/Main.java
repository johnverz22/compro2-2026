package com.johnverz;

import java.util.List;

import com.google.gson.Gson;
import com.johnverz.model.Task;
import com.johnverz.service.NetworkService;

public class Main {
    public static void main(String[] args) {
        String host = "jsonplaceholder.typicode.com"; //domain name
        int port = 80;
        String path = "/todos";

        NetworkService ns = new NetworkService(host, port);

        Task task = ns.fetch(path, 1);
        System.out.println("Single Task, id 1");
        System.out.println(task);
        System.out.println("All tasks");

        List<Task> tasks = ns.fetchAll(path);
        tasks.forEach((t) -> {
            System.out.println(t);
        });

    }
}