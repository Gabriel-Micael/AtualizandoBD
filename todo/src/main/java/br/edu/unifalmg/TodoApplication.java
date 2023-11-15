package br.edu.unifalmg;

import br.edu.unifalmg.repository.ChoreRepository;
import br.edu.unifalmg.repository.impl.FileChoreRepository;
import br.edu.unifalmg.repository.impl.MySQLChoreRepository;
import br.edu.unifalmg.service.ChoreService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class TodoApplication {

    public static void main(String[] args) throws SQLException {
//        ChoreRepository repository = new FileChoreRepository();
        ChoreRepository repository = new MySQLChoreRepository();
        ChoreService service = new ChoreService(repository);
        service.loadChores();
        service.toggleChore(service.getChores().get(4).getDescription(),service.getChores().get(4).getDeadline());
        repository.update(service.getChores().get(4));
        System.out.println("descrição: "+ service.getChores().get(4).getDescription() +
                "Iscompleted: "+ service.getChores().get(4).getIsCompleted() +
                "deadLine: "+ service.getChores().get(4).getDeadline());
//        service.addChore("Testing write on database feature", LocalDate.now());
        //service.addChore("Feriado", LocalDate.now().plusDays(1));
//        service.addChore("Chore #02", LocalDate.now().plusDays(8));
//        service.toggleChore("Chore #03", LocalDate.now().plusDays(1));
        System.out.println("Tamanho da lista de chores: " + service.getChores().size());
//        service.deleteChore("Chore #02", LocalDate.now().plusDays(8));
//        service.saveChores();
    }

}
