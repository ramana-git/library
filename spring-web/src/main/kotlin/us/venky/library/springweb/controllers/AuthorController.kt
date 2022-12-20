package us.venky.library.springweb.controllers

import org.springframework.web.bind.annotation.*
import us.venky.library.springweb.entities.Author
import us.venky.library.springweb.services.AuthorService
import java.util.UUID

@RestController @RequestMapping("authors")
class AuthorController(private val service: AuthorService){
    @GetMapping
    fun employees(): List<Author> {
        return service.get()
    }
    @PostMapping
    fun newEmployee(@RequestBody author: Author): Author {
        return service.create(author)
    }
    @GetMapping("{id}")
    fun employee(@PathVariable id: UUID): Author? {
        return service.get(id)
    }
    @PutMapping("{id}")
    fun update(@PathVariable id: UUID, @RequestBody author: Author): Author?{
        return service.update(id,author)
    }
    @DeleteMapping("{id}")
    fun delete(@PathVariable id: UUID): Author? {
        return service.delete(id)
    }
}