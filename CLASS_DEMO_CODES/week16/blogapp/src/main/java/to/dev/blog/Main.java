package to.dev.blog;

import java.util.List;

import to.dev.blog.model.Post;
import to.dev.blog.service.BlogService;

public class Main {
    public static void main(String[] args) {
        BlogService service = new BlogService();
        List<Post> blogs = service.fetchPosts();
        
        blogs.stream().limit(5).forEach(System.out::println);
    }
}