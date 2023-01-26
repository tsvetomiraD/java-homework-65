package rest.api.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class CommentController {
    @Autowired
    private Mapper mapper;

    @GetMapping("/comments")
    public Comment[] getPostComments() {
        return mapper.getAllComments();
    }
}
