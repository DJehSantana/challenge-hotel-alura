package com.br.hotel.dao;

import com.br.hotel.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

public class UsuarioDao extends GenericDao<Usuario, Long>{

    @PersistenceContext
    private EntityManager em;
    public UsuarioDao(EntityManager em, Class<Usuario> entityClass) {
        super(em, entityClass);
        this.em = em;
    }

    public boolean validarLogin (String login, String senha) {
        String msg = "";
        String jpql = "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha";
        try {
            Usuario result = em.createQuery(jpql, Usuario.class).setParameter("login", login)
                    .setParameter("senha", senha).getSingleResult();
            if (result != null) {
               return  true;
            }
        }catch (NoResultException e) {
            msg = "Login ou senha inválidos!";
            System.out.println(msg);
        }
        return false;
    }
}
