package us.venky.library.springweb.services

import org.springframework.stereotype.Service
import us.venky.library.springweb.entities.Cabinet
import us.venky.library.springweb.entities.Rack
import us.venky.library.springweb.repository.RackRepository
import java.util.*
@Service
class RackService(private val repo: RackRepository) {
    fun get(): List<Rack> {
        return repo.findAll()
    }
    fun get(id: UUID): Rack? {
        return repo.findById(id).orElse(null)
    }
    fun get(name: String): List<Rack> {
        return repo.findByName(name)
    }
    fun getByCabinet(cabinet: UUID): List<Rack> {
        return repo.findByCabinet(cabinet)
    }
    fun create(rack: Rack): Rack {
        rack.id=null
        return repo.save(rack)
    }
    fun update(id: UUID, rack: Rack): Rack?{
        val rk=get(id)
        rk?.let {rack.id=id;return repo.save(rack)}
        return null;
    }
    fun delete(id:UUID): Rack? {
        val rack=get(id)
        rack?.let { repo.deleteById(id) }
        return rack
    }
}