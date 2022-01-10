package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;

import com.emse.spring.faircorp.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/heaters")
@Transactional
public class HeaterController {

    private final HeaterDao heaterDao;
    private final RoomDao roomDao;

    public HeaterController(HeaterDao heaterDao, RoomDao roomDao) {
        this.heaterDao = heaterDao; this.roomDao= roomDao;
    }

    @CrossOrigin
    @GetMapping // (5)
    public List<HeaterDto> findAll() {
        return heaterDao.findAll().stream().sorted((heater1,heater2)->heater1.getId().compareTo(heater2.getId())).map(HeaterDto::new).collect(Collectors.toList());  // (6)
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public HeaterDto findbyid(@PathVariable Long id){
        System.out.println(heaterDao.findById(id).map(HeaterDto::new).toString());
        return heaterDao.findById(id).map(HeaterDto::new).orElse(null);
    }

    @CrossOrigin
    @PutMapping("/{id}/switch")
    public HeaterDto switchStatus(@PathVariable Long id) {
        Heater heater = heaterDao.findById(id).orElseThrow(IllegalArgumentException::new);
        if (heater.getHeaterStatus()== HeaterStatus.ON){
            heater.setHeaterStatus(HeaterStatus.OFF);
        } else{
            heater.setHeaterStatus(HeaterStatus.ON);
        }
        return new HeaterDto(heater);}
    @CrossOrigin
    @PostMapping
    public HeaterDto create(@RequestBody HeaterDto dto) {
        Room room = (roomDao.findRoomById(dto.getRoomId())).get(0);
        Heater heater;
        if (dto.getId() == null) {
            heater = heaterDao.save(new Heater(dto.getName(),dto.getPower(), dto.getHeaterStatus(),room));
        }
        else {
            heater = heaterDao.getById(dto.getId());
            heater.setHeaterStatus(dto.getHeaterStatus());
        }
        return new HeaterDto(heater);
    }


    @CrossOrigin
    @DeleteMapping(path = "/{id}/delete")
    public void delete(@PathVariable Long id) {
        heaterDao.deleteById(id);
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