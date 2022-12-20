package us.venky.library.springweb.services

import org.springframework.stereotype.Service
import us.venky.library.springweb.entities.Cabinet
import us.venky.library.springweb.repository.CabinetRepository
import java.util.*

@Service
class CabinetService(private val repo: CabinetRepository) {
    fun get(): List<Cabinet> {
        return repo.findAll()
    }
    fun get(id: UUID): Cabinet? {
        return repo.findById(id).orElse(null)
    }
    fun get(name: String): List<Cabinet> {
        return repo.findByName(name)
    }
    fun getByRoom(room: UUID): List<Cabinet> {
        return repo.findByRoom(room)
    }
    fun create(cabinet: Cabinet): Cabinet {
        cabinet.id=null
        return repo.save(cabinet)
    }
    fun update(id: UUID, cabinet: Cabinet): Cabinet?{
        val cab=get(id)
        cab?.let {cabinet.id=id;return repo.save(cabinet)}
        return null;
    }
    fun delete(id:UUID): Cabinet? {
        val cabinet=get(id)
        cabinet?.let { repo.deleteById(id) }
        return cabinet
    }
}