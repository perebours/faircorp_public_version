package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomDao extends JpaRepository<Room, Long>, RoomCustomDao {
    //List<Room> findById(@Param("id") ID id);
    @Modifying
    @Query("delete from Window w where w.room.id = :id")
    void deleteByRoom(@Param("id") Long id);
}
