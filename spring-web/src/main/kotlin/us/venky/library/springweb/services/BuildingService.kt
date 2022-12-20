package us.venky.library.springweb.services

import org.springframework.stereotype.Service
import us.venky.library.springweb.entities.Building
import us.venky.library.springweb.repository.BuildingRepository
import java.util.*

@Service
class BuildingService(private val repo: BuildingRepository) {
    fun get(): List<Building> {
        return repo.findAll()
    }
    fun get(zip: String): List<Building> {
        return repo.findByZip(zip)
    }
    fun get(id: UUID): Building? {
        return repo.findById(id).orElse(null)
    }
    fun create(building: Building): Building {
        building.id=null
        return repo.save(building)
    }
    fun update(id: UUID, building: Building): Building?{
        val build=get(id)
        build?.let {build.id=id;return repo.save(build)}
        return null;
    }
    fun delete(id:UUID): Building? {
        val building=get(id)
        building?.let { repo.deleteById(id) }
        return building
    }
}