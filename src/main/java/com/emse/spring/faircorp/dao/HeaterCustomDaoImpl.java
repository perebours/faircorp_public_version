package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class HeaterCustomDaoImpl implements HeaterCustomDao{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Room> findHeaterByName(String name) {
        String jpql = "select w from Heater w where w.name= :name";
        return em.createQuery(jpql, Room.class)
                .setParameter("name", name)
                .getResultList();
    }
    @Override
    public List<Room> findHeaterById(Long id){
        String jpql = "select w from Heater w where w.id= :id";
        return em.createQuery(jpql, Room.class)
                .setParameter("id", id)
                .getResultList();
    }
}
