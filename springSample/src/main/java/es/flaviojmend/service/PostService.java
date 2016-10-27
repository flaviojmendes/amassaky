package es.flaviojmend.service;

import es.flaviojmend.persistence.entity.Employee;
import es.flaviojmend.persistence.entity.Post;
import es.flaviojmend.persistence.repo.EmployeeRepository;
import es.flaviojmend.persistence.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by flavio.mendes on 23/08/2016.
 */
@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public void updatePost(Post post) throws Exception {
        if(post.getIdPost() == null) {
            throw new Exception("Não é possível atualizar um post com Id nulo.");
        }

        postRepository.save(post);
    }

    public void addPost(Post post) {
        postRepository.save(post);
    }

    public Iterable<Post> listPosts(){
        return postRepository.findAll();
    }

    public void deletePost(Post post) {
        postRepository.delete(post);
    }

}
