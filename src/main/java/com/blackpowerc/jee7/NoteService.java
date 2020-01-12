package com.blackpowerc.jee7;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Cette classe est responsable des opérations de CRUD sur l'entité {@link Note},
 * @author jordy
 * @since 0.0.0
 */
@RequestScoped
public class NoteService implements UpdateOperation, ReadOperation
{
    @PersistenceContext(unitName = "notePU")
    private EntityManager em ;

    public NoteService() {}


    @Override
    public List<Note> findAll() {
        return null;
    }

    @Override
    public Optional<Note> findById(Serializable id) {
        return Optional.empty();
    }

    @Override
    public List<Note> find(int limit, int offset) {
        return null;
    }

    @Override
    public int deleteAll() {
        return 0;
    }

    @Override
    public boolean deleteById(Serializable id) {
        return false;
    }

    @Override
    public Note update(@Valid final Note note) {
        return null;
    }

    @Override
    public void insert(@Valid Note note) {

    }
}
