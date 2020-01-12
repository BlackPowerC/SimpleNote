package com.blackpowerc.jee7;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Interface pour déclarer les opérations de lecture sur l'entité {@link Note}.
 * @author jordy
 * @since 0.0.0
 */
public interface ReadOperation
{
    List<Note> findAll() ;

    Optional<Note> findById(Serializable id) ;

    List<Note> find(final int limit, final int offset) ;
}
