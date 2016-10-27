package es.flaviojmend.persistence.repo;

import es.flaviojmend.persistence.entity.Comment;
import es.flaviojmend.persistence.entity.PostCategory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by flavio on 19/07/16.
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {



}

