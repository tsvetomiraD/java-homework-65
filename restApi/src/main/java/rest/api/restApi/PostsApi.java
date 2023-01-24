package rest.api.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/posts")
public class PostsApi {
    @Autowired
    private Mapper mapper;

    @GetMapping("/posts") //todo check how to set
    public Post[] getAllPosts() {
        return mapper.getAllPosts();
    }

    // create user rest API
    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post)  {
        if (mapper.getPostById(post.id)==null) {
            int id = mapper.insertPost(post);
            return mapper.getPostById(post.id);
        } else {
            throw new RuntimeException(); //todo exception
        }
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer id) {
        Post post = mapper.getPostById(id);
        if(post==null) {
            throw new RuntimeException(); //todo
        }
        return ResponseEntity.ok(post);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestBody Post post) {
        if (mapper.updatePost(post, id) == 0) {
            throw new RuntimeException(); //todo
        }

        return ResponseEntity.ok(mapper.getPostById(id));
    }
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePost(@PathVariable int id) {
        mapper.deletePost(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/posts/{id}/comments")
    public Comment[] getPostCommentsFromPostById(@PathVariable Integer id) {
        return mapper.getCommentsByPostId(id);
    }

    @GetMapping("/comments")
    public Comment[] getPostComments() {
        return mapper.getAllComments();
    }
}