package us.venky.library.springweb.controllers

import org.springframework.web.bind.annotation.*
import us.venky.library.springweb.entities.Member
import us.venky.library.springweb.services.MemberService
import java.util.UUID

@RestController @RequestMapping("titles")
class TitleController(private val service: MemberService){
    @GetMapping
    fun list(): List<Member> {
        return service.get()
    }
    @GetMapping("search")
    fun searchByIsbn(@RequestParam isbn: String): List<Member> {
        return service.get(isbn)
    }
    @PostMapping
    fun new(@RequestBody member: Member): Member {
        return service.create(member)
    }
    @GetMapping("{id}")
    fun get(@PathVariable id: UUID): Member? {
        return service.get(id)
    }
    @PutMapping("{id}")
    fun update(@PathVariable id: UUID, @RequestBody member: Member): Member?{
        return service.update(id,member)
    }
    @DeleteMapping("{id}")
    fun delete(@PathVariable id: UUID): Member? {
        return service.delete(id)
    }
}