package es.flaviojmend.service;

import es.flaviojmend.persistence.entity.Cliente;
import es.flaviojmend.persistence.repo.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by flavio.mendes on 23/08/2016.
 */
@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public void cadastrarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }


//
//    public void updateComment(Comment comment) throws Exception {
//        if(comment.getIdComment() == null) {
//            throw new Exception("Não é possível atualizar um comentário com Id nulo.");
//        }
//
//        commentRepository.save(comment);
//    }
//
//    public void addComment(Comment comment) {
//        commentRepository.save(comment);
//    }
//
//    public Iterable<Comment> listComments(){
//        return commentRepository.findAll();
//    }
//
//    public void deleteComment(Comment comment) {
//        commentRepository.delete(comment);
//    }

}
