package to.dev.blog.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import java.util.*;

import javax.management.RuntimeErrorException;

import to.dev.blog.model.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

public class BlogService {
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public List<Post> fetchPosts(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dev.to/api/articles"))
                .header("Accept", "application/json")
                .GET()
                .build();
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200){
                Type listType = new TypeToken<List<Post>>(){}.getType();
                return gson.fromJson(response.body(), listType);
            }else{
                throw new RuntimeException("HTTP Error: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


        return new ArrayList<Post>();
    }
}
