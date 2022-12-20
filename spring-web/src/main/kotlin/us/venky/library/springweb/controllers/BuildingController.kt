package us.venky.library.springweb.controllers

import org.springframework.web.bind.annotation.*
import us.venky.library.springweb.entities.Building
import us.venky.library.springweb.services.BuildingService
import java.util.UUID

@RestController @RequestMapping("buildings")
class BuildingController(private val service: BuildingService){
    @GetMapping
    fun list(): List<Building> {
        return service.get()
    }
    @GetMapping("search")
    fun searchByZip(@RequestParam zip: String): List<Building> {
        return service.get(zip)
    }
    @PostMapping
    fun new(@RequestBody building: Building): Building {
        return service.create(building)
    }
    @GetMapping("{id}")
    fun get(@PathVariable id: UUID): Building? {
        return service.get(id)
    }
    @PutMapping("{id}")
    fun update(@PathVariable id: UUID, @RequestBody building: Building): Building?{
        return service.update(id,building)
    }
    @DeleteMapping("{id}")
    fun delete(@PathVariable id: UUID): Building? {
        return service.delete(id)
    }
}