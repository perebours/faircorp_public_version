package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RoomCustomDaoImpl implements RoomCustomDao{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Room> findRoomByName(String name) {
        String jpql = "select w from Room w where w.name= :name";
        return em.createQuery(jpql, Room.class)
                .setParameter("name", name)
                .getResultList();
    }
    @Override
    public List<Room> findRoomById(Long id){
        String jpql = "select w from Room w where w.id= :id";
        return em.createQuery(jpql, Room.class)
                .setParameter("id", id)
                .getResultList();
    }
}
