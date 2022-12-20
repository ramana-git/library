package us.venky.library.springweb.services

import org.springframework.stereotype.Service
import us.venky.library.springweb.entities.Author
import us.venky.library.springweb.repository.AuthorRepository
import java.util.*

@Service
class AuthorService(private val repo: AuthorRepository) {
    fun get(): List<Author> {
        return repo.findAll()
    }
    fun get(id: UUID): Author? {
        return repo.findById(id).orElse(null)
    }
    fun create(author: Author): Author {
        return repo.save(author)
    }
    fun update(id: UUID, author: Author): Author?{
        val emp=get(id)
        emp?.let {repo.save(Author(id, author.firstName, author.lastName, author.address))}
        return null;
    }
    fun delete(id:UUID): Author? {
        val employee=get(id)
        employee?.let { repo.deleteById(id) }
        return employee
    }
}