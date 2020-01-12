package com.blackpowerc.jee7;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * Interface pour déclarer les opérations de modifications (CUD)
 * @since 0.0.0
 * @author jordy
 */
public interface UpdateOperation
{
    int deleteAll() ;

    boolean deleteById(Serializable id) ;

    Note update(@Valid final Note note) ;

    void insert(@Valid Note note) ;
}