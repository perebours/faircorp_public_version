package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "ROOM")
public class Room {

    @Column(nullable=true)
    private Double current_temperature;
    @Column(nullable=true)
    private Double target_temperature;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private int floor;

    @Column(nullable=false)
    private String name;



    @OneToMany(mappedBy= "room")
    private Set<Heater> heaters;

    @OneToMany(mappedBy= "room")
    private Set<Window> windows;


    public Room() {
    }

    public Room(String name,  int floor, double current_temperature, double target_temperature) {
        this.name = name;
        this.floor=floor;
        this.current_temperature=current_temperature;
        this.target_temperature=target_temperature;
    }

    public Long getId() {
        return this.id;
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

    public double getCurrentTemperature() { return current_temperature;}
    public double getTargetTemperature() { return target_temperature;}

    public Set<Window> getWindows() { return windows;}

    public Set<Heater> getHeaters() {
        return heaters;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setCurrentTemperature(Double current_temperature) {
        this.current_temperature = current_temperature;
    }

    public void setTargetTemperature(Double target_temperature) {
        this.target_temperature = target_temperature;
    }
    /*
    public Set<Long>  getWindowsId(){
        return this.windowsId;
    }

     */
}
