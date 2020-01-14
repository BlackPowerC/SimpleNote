package com.blackpowerc.jee7;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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
        return em.createNamedQuery("note.findAll", Note.class).getResultList() ;
    }

    @Override
    public Optional<Note> findById(Serializable id) {
        return Optional.ofNullable(em.find(Note.class, id)) ;
    }

    @Override
    public List<Note> find(int limit, int offset) {
        return em.createNamedQuery("note.findAll", Note.class).setFirstResult(limit*offset).setMaxResults(limit).getResultList() ;
    }

    @Override
    @Transactional
    public int deleteAll() {
        return em.createNamedQuery("note.deleteAll").executeUpdate() ;
    }

    @Override
    @Transactional
    public boolean deleteById(Serializable id) {
        return em.createNamedQuery("note.deleteById").setParameter("id", id).executeUpdate() == 1 ;
    }

    @Override
    @Transactional
    public Note update(@Valid final Note note) {
        return em.merge(note) ;
    }

    @Override
    @Transactional
    public void insert(@Valid Note note) {
        em.persist(note) ;
    }
}
