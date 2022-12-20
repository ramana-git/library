package us.venky.library.springweb.controllers

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import us.venky.library.springweb.entities.Library
import us.venky.library.springweb.services.LibraryService
import java.util.UUID

@RestController @RequestMapping("library")
class LibraryController(private val service: LibraryService){
    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE,MediaType.TEXT_XML_VALUE])
    fun list(): List<Library> {
        return service.get()
    }
    @PostMapping
    fun new(@RequestBody library: Library): Library {
        return service.create(library)
    }
    @GetMapping("{id}")
    fun get(@PathVariable id: UUID): Library? {
        return service.get(id)
    }
    @PutMapping("{id}")
    fun update(@PathVariable id: UUID, @RequestBody library: Library): Library?{
        return service.update(id,library)
    }
    @DeleteMapping("{id}")
    fun delete(@PathVariable id: UUID): Library? {
        return service.delete(id)
    }
}