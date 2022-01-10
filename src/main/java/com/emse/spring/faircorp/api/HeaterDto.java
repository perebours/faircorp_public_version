package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;


public class HeaterDto {

    private Long id;
    private String name;
    private Long power;
    private Long roomId;
    private String roomName;
    private HeaterStatus heaterStatus;

    public HeaterDto() {

    }
    public HeaterDto(Heater heater) {
        this.id=heater.getId();
        this.name=heater.getName();
        this.power=heater.getPower();
        this.roomId=heater.getRoom().getId();
        this.roomName=heater.getRoom().getName();
        this.heaterStatus =heater.getHeaterStatus();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getRoomId() {
        return roomId;
    }
    public  String getRoomName() {
        return roomName;
    }

    public Long getPower() {
        return power;
    }

    public com.emse.spring.faircorp.model.HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }
}