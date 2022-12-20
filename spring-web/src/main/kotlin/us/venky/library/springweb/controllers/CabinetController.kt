package us.venky.library.springweb.controllers

import org.springframework.web.bind.annotation.*
import us.venky.library.springweb.entities.Cabinet
import us.venky.library.springweb.services.CabinetService
import java.util.UUID

@RestController @RequestMapping("cabinets")
class CabinetController(private val service: CabinetService){
    @GetMapping
    fun list(): List<Cabinet> {
        return service.get()
    }
    @GetMapping("search")
    fun search(@RequestParam name: String): List<Cabinet> {
        return service.get(name)
    }
    @GetMapping("searchByRoom")
    fun searchByRoom(@RequestParam id: UUID): List<Cabinet> {
        return service.getByRoom(id)
    }
    @PostMapping
    fun new(@RequestBody cabinet: Cabinet): Cabinet {
        return service.create(cabinet)
    }
    @GetMapping("{id}")
    fun get(@PathVariable id: UUID): Cabinet? {
        return service.get(id)
    }
    @PutMapping("{id}")
    fun update(@PathVariable id: UUID, @RequestBody cabinet: Cabinet): Cabinet?{
        return service.update(id,cabinet)
    }
    @DeleteMapping("{id}")
    fun delete(@PathVariable id: UUID): Cabinet? {
        return service.delete(id)
    }
}