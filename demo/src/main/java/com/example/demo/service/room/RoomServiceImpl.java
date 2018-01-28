package com.example.demo.service.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.configuration.PageReqConfig;
import com.example.demo.dao.RoomDao;
import com.example.demo.dto.RoomDTO;
import com.example.demo.exceptions.NotFoundExcept;

import com.example.demo.model.Room;


@Service
public class RoomServiceImpl implements RoomService {
	
	private static final Integer NotANullId = -1;

	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public RoomDTO findById(Integer id) throws NotFoundExcept {
		final Room r = Optional.ofNullable(roomDao.findOne(id)).orElseThrow(() -> new NotFoundExcept());
		return map(r);
	}

	@Override
	public List<RoomDTO> findAll(Integer page, Integer size) {
		final Iterable<Room> findAll = roomDao.findAll(PageReqConfig.newPageRequest(page, size));
		final List<RoomDTO> res = new ArrayList<>();
		findAll.forEach(r -> {final RoomDTO rDTO = map(r); res.add(rDTO);});
		return res;
	}

	@Override
	public RoomDTO create(RoomDTO roomDTO) {
		final Room r = map(roomDTO);
		return map(roomDao.save(r));
	}

	@Override
	public void update(RoomDTO roomDTO) {
		final Room r = map(roomDTO);
		roomDao.save(r);
	}

	@Override
	public void delete(Integer idRoom) {
		roomDao.delete(idRoom);
	}

	@Override
	public Room map(RoomDTO room) {
		Room r =  Optional.ofNullable(roomDao.findOne(Optional.ofNullable(room.getId()).orElse(NotANullId))).orElse(new Room());
		r.setId(room.getId());
		r.setRoomNumber(room.getRoomNumber());
		r.setClinic(room.getClinic());
		
		return r;
		
	}

	@Override
	public RoomDTO map(Room room) {
		return dozer.map(room, RoomDTO.class);
	}

}
