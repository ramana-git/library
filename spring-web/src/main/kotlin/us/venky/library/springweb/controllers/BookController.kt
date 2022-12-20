package us.venky.library.springweb.controllers

import org.springframework.web.bind.annotation.*
import us.venky.library.springweb.entities.Book
import us.venky.library.springweb.services.BookService
import java.util.UUID

@RestController @RequestMapping("books")
class BookController(private val service: BookService){
    @GetMapping
    fun list(): List<Book> {
        return service.get()
    }
    @GetMapping("title/{id}")
    fun getByTitle(@PathVariable id: UUID): List<Book> {
        return service.getByTitle(id)
    }
    @PostMapping
    fun new(@RequestBody book: Book): Book {
        return service.create(book)
    }
    @GetMapping("{id}")
    fun get(@PathVariable id: UUID): Book? {
        return service.get(id)
    }
    @PutMapping("{id}")
    fun update(@PathVariable id: UUID, @RequestBody book: Book): Book?{
        return service.update(id,book)
    }
    @DeleteMapping("{id}")
    fun delete(@PathVariable id: UUID): Book? {
        return service.delete(id)
    }
    @GetMapping("{id}/member/{mid}")
    fun checkout(@PathVariable id: UUID, @PathVariable mid: UUID): Book? {
        return service.checkout(id,mid)
    }
    @GetMapping("checkin/{id}")
    fun checkout(@PathVariable id: UUID): Book? {
        return service.checkin(id)
    }
}