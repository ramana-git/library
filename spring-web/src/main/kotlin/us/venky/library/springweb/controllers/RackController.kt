package us.venky.library.springweb.controllers

import org.springframework.web.bind.annotation.*
import us.venky.library.springweb.entities.Rack
import us.venky.library.springweb.services.RackService
import java.util.UUID

@RestController @RequestMapping("racks")
class RackController(private val service: RackService){
    @GetMapping
    fun list(): List<Rack> {
        return service.get()
    }
    @GetMapping("search")
    fun search(@RequestParam name: String): List<Rack> {
        return service.get(name)
    }
    @GetMapping("searchByCabinet")
    fun searchByCabinet(@RequestParam id: UUID): List<Rack> {
        return service.getByCabinet(id)
    }
    @PostMapping
    fun new(@RequestBody rack: Rack): Rack {
        return service.create(rack)
    }
    @GetMapping("{id}")
    fun get(@PathVariable id: UUID): Rack? {
        return service.get(id)
    }
    @PutMapping("{id}")
    fun update(@PathVariable id: UUID, @RequestBody rack: Rack): Rack?{
        return service.update(id,rack)
    }
    @DeleteMapping("{id}")
    fun delete(@PathVariable id: UUID): Rack? {
        return service.delete(id)
    }
}