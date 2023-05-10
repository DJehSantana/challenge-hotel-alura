package com.br.hotel.dao;

import com.br.hotel.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UsuarioDao extends GenericDao<Usuario, Long>{

    @PersistenceContext
    private EntityManager em;
    public UsuarioDao(EntityManager em, Class<Usuario> entityClass) {
        super(em, entityClass);
        this.em = em;
    }

    public boolean validarLogin (String login, String senha) {
        String jpql = "SELECT l FROM Login l WHERE l.login = :login AND l.senha = :senha";
        Usuario result = em.createQuery(jpql, Usuario.class).setParameter("login", login)
                .setParameter("senha", senha).getSingleResult();
        if (result != null) {
            return true;
        }
        return false;
    }
}
