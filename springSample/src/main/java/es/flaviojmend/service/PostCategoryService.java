package es.flaviojmend.service;

import es.flaviojmend.persistence.entity.Employee;
import es.flaviojmend.persistence.entity.PostCategory;
import es.flaviojmend.persistence.repo.EmployeeRepository;
import es.flaviojmend.persistence.repo.PostCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by flavio.mendes on 23/08/2016.
 */
@Service
public class PostCategoryService {

    @Autowired
    PostCategoryRepository postCategoryRepository;

    public void updatePostCategory(PostCategory postCategory) throws Exception {
        if(postCategory.getIdPostCategory() == null) {
            throw new Exception("Não é possível atualizar uma Categoria com Id nulo.");
        }

        postCategoryRepository.save(postCategory);
    }

    public void addPostCategory(PostCategory postCategory) {
        postCategoryRepository.save(postCategory);
    }

    public Iterable<PostCategory> listPostCategories(){
        return postCategoryRepository.findAll();
    }

    public void deletePostCategory(PostCategory postCategory) {
        postCategoryRepository.delete(postCategory);
    }

}
