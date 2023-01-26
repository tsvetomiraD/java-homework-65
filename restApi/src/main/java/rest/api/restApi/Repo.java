package rest.api.restApi;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
@Service
public class Repo {
    private Mapper mapper;
    public Post save( Post post)  {
        if (mapper.getPostById(post.id)==null) {
            int id = mapper.insertPost(post);
            return mapper.getPostById(post.id);
        } else {
            throw new RuntimeException(); //todo exception
        }
    }

    public Post getPostById( Integer id) {
        Post post = mapper.getPostById(id);
        if(post==null) {
            throw new RuntimeException(); //todo
        }
        return post;
    }
}
