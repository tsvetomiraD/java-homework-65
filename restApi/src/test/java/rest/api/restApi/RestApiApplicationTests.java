package rest.api.restApi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RestApiApplicationTests {

    @Test
    public void enableAutoConfiguration() {
        SpringApplication.run(SpringbootMybatisCrudExampleApplication.class);
    }

    @Test
    public void testRepo() {
        Repo repo = new Repo();
        Post post = new Post();
        repo.save(post);
        assertNotNull(repo.getPostById(1));
    }

    @Test
    public void testService() {
        //repo with annotation service
        Repo repo = new Repo();
        Post post = new Post();
        repo.save(post);
        assertNotNull(repo.getPostById(1));
    }

    @Test
    public void testController() {
    }

    @Test
    public void testRestController() {
    }

    @Test
    public void testGetMapping() {
        PostsController pc = new PostsController();
        assertNotNull(pc.getAllPosts());
    }

    @Test
    public void testRequestMapping() {
        PostsController pc = new PostsController();
        assertNotNull(pc.getAllPosts());
    }
}
