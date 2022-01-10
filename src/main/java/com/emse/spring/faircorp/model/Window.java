package com.emse.spring.faircorp.model;

import javax.persistence.*;

@Entity
@Table(name= "RWINDOW")
public class Window {
    @Id
    @GeneratedValue
    private Long id;

    // (4)
    @Column(nullable=false)
    private String name;

    //Mettre le room ?
    @ManyToOne
    private Room room;

    //5
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private WindowStatus windowStatus;

    public Window() {
    }

    public Window(Room room, String name, WindowStatus status) {
        this.room=room;
        this.windowStatus = status;
        this.name = name;
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

    public WindowStatus getWindowStatus() {
        return windowStatus;
    }

    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }

    public Room getRoom() { return this.room; }
}
