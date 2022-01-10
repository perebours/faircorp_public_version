package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    private final WindowDao windowDao;
    private final RoomDao roomDao;
    private final HeaterDao heaterDao;

    public RoomController(WindowDao windowDao, RoomDao roomDao, HeaterDao heaterDao) {
        this.windowDao = windowDao; this.roomDao= roomDao; this.heaterDao=heaterDao;
    }

    @CrossOrigin
    @GetMapping // (5)
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().sorted((room1,room2)->room1.getId().compareTo(room2.getId())).map(RoomDto::new).collect(Collectors.toList());  // (6)
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public RoomDto findbyid(@PathVariable Long id){
        System.out.println(roomDao.findById(id).map(RoomDto::new).toString());
        return roomDao.findById(id).map(RoomDto::new).orElse(null);
    }

    @CrossOrigin
    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto) {

        Room room;
        //List<Long> windowsId=dto.getWindowsId();
        if (dto.getId() == null) {
            room = roomDao.save(new Room(dto.getName(),dto.getFloor(), dto.getCurrentTemperature(), dto.getTargetTemperature()));
        }
        else {
            room = roomDao.getById(dto.getId());
            room.setCurrentTemperature(dto.getCurrentTemperature());
            room.setTargetTemperature(dto.getTargetTemperature());
        }
        return new RoomDto(room);
    }

    @CrossOrigin
    @DeleteMapping(path = "/{id}/delete")
    public void delete(@PathVariable Long id) {
        windowDao.deleteByRoom(id);heaterDao.deleteByRoom(id); roomDao.deleteById(id);
    }

    class MessageDto {
        String message;

        public MessageDto(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }


}