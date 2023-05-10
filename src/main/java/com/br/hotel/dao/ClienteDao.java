package com.br.hotel.dao;

import com.br.hotel.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ClienteDao extends GenericDao<Cliente, Long> {

    @PersistenceContext
    private EntityManager em;
    public ClienteDao(EntityManager em, Class<Cliente> entityClass) {
        super(em, entityClass);
        this.em = em;
    }

    public boolean login (String login, String password) {

        return false;
    }
}
