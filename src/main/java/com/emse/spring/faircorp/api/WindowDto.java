package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;

public class WindowDto {
    private Long id;
    private String name;
    private WindowStatus status;
    private String roomName;
    private Long roomId;
    //private Room room;

    public WindowDto() {
    }

    public WindowDto(Window window) {
        this.id = window.getId();
        this.name = window.getName();
        this.status = window.getWindowStatus();
        this.roomName=window.getRoom().getName();
        this.roomId=window.getRoom().getId();
        /*
        this.roomName = window.getRoom().getName();
        this.roomId = window.getRoom().getId();

         */
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

    public WindowStatus getStatus() {
        return status;
    }

    public void setStatus(WindowStatus status) {
        this.status = status;
    }
/*
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

 */
/*
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

 */

    public Long getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }
}