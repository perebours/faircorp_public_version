package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class RoomDaoTest {
    @Autowired
    private RoomDao roomDao;

    @Test
    public void shouldFindAWindow() {
        Room room = roomDao.getById(-10L);
        Assertions.assertThat(room.getName()).isEqualTo("Room1");
        Assertions.assertThat(room.getCurrentTemperature()).isEqualTo(22.3);
    }
    @Test
    public void shouldFindRoomByName() {
        List<Room> result = roomDao.findRoomByName("Room1");
        Assertions.assertThat(result)
                .hasSize(1)
                .extracting("id", "name");
    }

    @Test
    public void shouldNotFindRoomByName() {
        List<Room> result = roomDao.findRoomByName("Room3");
        Assertions.assertThat(result).isEmpty();
    }


}
