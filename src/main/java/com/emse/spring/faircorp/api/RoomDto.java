package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RoomDto {
    private Long id;
    private String name;
    private int floor;
    private Double targetTemperature=null;
    private Double currentTemperature=null;
    //private List<Long> WindowsId=new ArrayList<Long>();
    //private List<Long> HeatersId=new ArrayList<Long>();
    //private Set<Window> windows;
    private ArrayList<WindowDto> windows=new ArrayList<WindowDto>();
    private ArrayList<HeaterDto> heaters=new ArrayList<HeaterDto>();
    public RoomDto(){};
    public RoomDto(Room room) {
        this.id=room.getId();
        this.name=room.getName();
        this.floor=room.getFloor();
        //this.windows=room.getWindows();
        //this.heaters=room.getHeaters();
        try {
            this.currentTemperature =room.getCurrentTemperature();
            this.targetTemperature = room.getTargetTemperature();
        }catch(NullPointerException e){
        }
        if(room.getWindows()!=null && room.getHeaters()!=null) {
            for (Window w : room.getWindows()) {
                //WindowsId.add(w.getId());
                windows.add(new WindowDto(w));
            }
            for (Heater h : room.getHeaters()) {
                //HeatersId.add(h.getId());
                heaters.add(new HeaterDto(h));
            }
            heaters.sort((heater1, heater2) -> heater1.getId().compareTo(heater2.getId()));
            windows.sort((window1, window2) -> window1.getId().compareTo(window2.getId()));
        }



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

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }


    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    /*public List<Long> getWindowsId() {
        return WindowsId;
    }
    */

    public List<WindowDto> getWindows() {
        return windows;
    }
    public List<HeaterDto> getHeaters() {
        return heaters;
    }


    /*
    public List<Long> getHeatersId(){
        return HeatersId;
    }
    */
    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}