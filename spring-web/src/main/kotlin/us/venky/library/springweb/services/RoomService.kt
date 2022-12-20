package us.venky.library.springweb.services

import org.springframework.stereotype.Service
import us.venky.library.springweb.entities.Room
import us.venky.library.springweb.repository.RoomRepository
import java.util.*

@Service
class RoomService(private val repo: RoomRepository) {
    fun get(): List<Room> {
        return repo.findAll()
    }
    fun get(id: UUID): Room? {
        return repo.findById(id).orElse(null)
    }
    fun get(name: String): List<Room> {
        return repo.findByName(name)
    }
    fun getByBuilding(id: UUID): List<Room> {
        return repo.findByBuilding(id);
    }
    fun create(building: Room): Room {
        building.id=null
        return repo.save(building)
    }
    fun update(id: UUID, room: Room): Room?{
        val rm=get(id)
        rm?.let {room.id=id;return repo.save(room)}
        return null;
    }
    fun delete(id:UUID): Room? {
        val room=get(id)
        room?.let { repo.deleteById(id) }
        return room
    }
}