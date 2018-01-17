package dao;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import model.Room;

public interface RoomDao extends PagingAndSortingRepository<Room, Integer> {

}
