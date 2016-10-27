package es.flaviojmend.service;

import es.flaviojmend.command.ContratacaoCommand;
import es.flaviojmend.persistence.entity.Cliente;
import es.flaviojmend.persistence.entity.Contratacao;
import es.flaviojmend.persistence.entity.Massagista;
import es.flaviojmend.persistence.repo.ClienteRepository;
import es.flaviojmend.persistence.repo.ContratacaoRepository;
import es.flaviojmend.persistence.repo.MassagistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

/**
 * Created by flavio.mendes on 23/08/2016.
 */
@Service
public class ContratacaoService {

    @Autowired
    ContratacaoRepository contratacaoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    MassagistaRepository massagistaRepository;

    public void contratarServico(ContratacaoCommand contratacaoCommand) throws Exception {

        List<Massagista> massagistas = massagistaRepository
                .findByEspecialidadeAndSexo(contratacaoCommand.getEspecialidade(),
                        contratacaoCommand.getSexo());

        Contratacao contratacao = new Contratacao();

        Cliente cliente = clienteRepository.findOne(contratacaoCommand.getIdCliente());

        contratacao.setCliente(cliente);
        contratacao.setMassagista(massagistas.get(0));


        /////
        final String username = "amassakyapp@gmail.com";
        final String password = "massagem";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("amassakyapp@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(massagistas.get(0).getEmail()));
            message.setSubject("Nova Massagem");
            message.setText("Voce tem nova massagem");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        /////



        contratacaoRepository.save(contratacao);

    }
}