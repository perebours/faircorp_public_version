package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HeaterDao extends JpaRepository<Heater, Long> {
    //List<Heater> findById(@Param("id") ID id);
    //@Modifying // (3)
    @Modifying
    @Query("delete from Heater h where h.room.id = :id")
    void deleteByRoom(@Param("id") Long id);
}
