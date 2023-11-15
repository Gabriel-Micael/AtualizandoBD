package br.edu.unifalmg.repository;

import br.edu.unifalmg.domain.Chore;
import br.edu.unifalmg.exception.NullChoreException;
import br.edu.unifalmg.exception.NullIsCompletedException;

import java.sql.SQLException;
import java.util.List;

public interface ChoreRepository {

    List<Chore> load();

    boolean saveAll(List<Chore> chores);

    boolean save(Chore chore);

    boolean update(Chore chore) throws NullChoreException, NullIsCompletedException, SQLException;

}
