package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;

import java.util.List;

public interface HeaterCustomDao {
    List<Room> findHeaterByName(String name);
    List<Room> findHeaterById(Long id);

}
