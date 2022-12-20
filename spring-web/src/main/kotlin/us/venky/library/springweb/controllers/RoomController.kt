package us.venky.library.springweb.controllers

import org.springframework.web.bind.annotation.*
import us.venky.library.springweb.entities.Room
import us.venky.library.springweb.services.RoomService
import java.util.UUID

@RestController @RequestMapping("rooms")
class RoomController(private val service: RoomService){
    @GetMapping
    fun list(): List<Room> {
        return service.get()
    }
    @GetMapping("search")
    fun searchByZip(@RequestParam name: String): List<Room> {
        return service.get(name)
    }
    @GetMapping("searchByBuilding")
    fun searchByBuilding(@RequestParam id: UUID): List<Room> {
        return service.getByBuilding(id)
    }
    @PostMapping
    fun new(@RequestBody room: Room): Room {
        return service.create(room)
    }
    @GetMapping("{id}")
    fun get(@PathVariable id: UUID): Room? {
        return service.get(id)
    }
    @PutMapping("{id}")
    fun update(@PathVariable id: UUID, @RequestBody room: Room): Room?{
        return service.update(id,room)
    }
    @DeleteMapping("{id}")
    fun delete(@PathVariable id: UUID): Room? {
        return service.delete(id)
    }
}