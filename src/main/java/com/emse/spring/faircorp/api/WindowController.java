package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/windows")
@Transactional
public class WindowController {

    private final WindowDao windowDao;
    private final RoomDao roomDao;

    public WindowController(WindowDao windowDao, RoomDao roomDao) {
        this.windowDao = windowDao; this.roomDao= roomDao;
    }

    @CrossOrigin
    @GetMapping // (5)
    public List<WindowDto> findAll() {
        return windowDao.findAll().stream().sorted((win1,win2)->win1.getId().compareTo(win2.getId())).map(WindowDto::new).collect(Collectors.toList());  // (6)
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public WindowDto findbyid(@PathVariable Long id){
        return windowDao.findById(id).map(WindowDto::new).orElse(null);
    }

    @CrossOrigin
    @PutMapping("/{id}/switch")
    public WindowDto switchStatus(@PathVariable Long id) {
        Window window = windowDao.findById(id).orElseThrow(IllegalArgumentException::new);
       if (window.getWindowStatus()== WindowStatus.OPEN){
            window.setWindowStatus(WindowStatus.CLOSED);
        } else{
            window.setWindowStatus(WindowStatus.OPEN);
        }
        return new WindowDto(window);}
    @CrossOrigin
    @PostMapping
    public WindowDto create(@RequestBody WindowDto dto) {

        Room room = (roomDao.findRoomById(dto.getRoomId())).get(0);
        Window window;
        if (dto.getId() == null) {
            window = windowDao.save(new Window(room, dto.getName(), dto.getStatus()));
        }
        else {
            window = windowDao.getById(dto.getId());
            window.setWindowStatus(dto.getStatus());
            window.setName(dto.getName());
            //on pourrait aussi modifier roomId et roomName.
        }
        return new WindowDto(window);
    }
    @CrossOrigin
    @DeleteMapping(path = "/{id}/delete")
    public void delete(@PathVariable Long id) {
        windowDao.deleteById(id);
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