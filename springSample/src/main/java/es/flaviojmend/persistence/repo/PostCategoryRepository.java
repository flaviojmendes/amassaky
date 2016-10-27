package es.flaviojmend.persistence.repo;

import es.flaviojmend.persistence.entity.Post;
import es.flaviojmend.persistence.entity.PostCategory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by flavio on 19/07/16.
 */
public interface PostCategoryRepository extends CrudRepository<PostCategory, Long> {



}

