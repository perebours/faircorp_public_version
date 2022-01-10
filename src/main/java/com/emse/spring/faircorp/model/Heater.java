package com.emse.spring.faircorp.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name= "HEATER")
public class Heater {
    @Id
    @GeneratedValue
    private Long id;

    // (4)
    @Column(nullable=false)
    private String name;

    @Nullable
    private Long power;

    //@Column(nullable=false)
    @ManyToOne
    private Room room;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private HeaterStatus heaterStatus;

    public Heater() {
    }

    public Heater(String name, Long power, HeaterStatus status, Room room) {
        this.heaterStatus = status;
        this.name = name;
        this.room=room;
        this.power=power;
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

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus HeaterStatus) {
        this.heaterStatus = HeaterStatus;
    }

    public Long getPower() {
        return this.power;
    }

    public Room getRoom() {
        return this.room;
    }
}
