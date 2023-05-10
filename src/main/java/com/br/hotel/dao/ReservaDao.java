package com.br.hotel.dao;

import com.br.hotel.model.Reserva;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ReservaDao extends GenericDao<Reserva, Long>{
    @PersistenceContext
    private EntityManager em;


    public ReservaDao(EntityManager em, Class<Reserva> entityClass) {
        super(em, entityClass);
        this.em = em;
    }
}
