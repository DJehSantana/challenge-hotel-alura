package com.br.hotel.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryUtil {
    private static final EntityManagerFactory FACTORY = Persistence
            .createEntityManagerFactory("hotel");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
