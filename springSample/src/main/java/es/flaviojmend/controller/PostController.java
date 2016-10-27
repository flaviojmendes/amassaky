package es.flaviojmend.controller;

import es.flaviojmend.persistence.entity.Employee;
import es.flaviojmend.persistence.entity.Post;
import es.flaviojmend.service.EmployeeService;
import es.flaviojmend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by flavio.mendes on 22/08/2016.
 */

@RestController
@RequestMapping("/post")
public class PostController {


    @Autowired
    PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Post> get() {
        return postService.listPosts();
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody Post post) {
        postService.addPost(post);

        HttpHeaders httpHeaders = new HttpHeaders();

        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> put(@RequestBody Post post) {
        HttpHeaders httpHeaders = new HttpHeaders();

        try {
            postService.updatePost(post);
        } catch (Exception e) {
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?>  delete(@RequestBody Post post) {
        postService.deletePost(post);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
    }

}