package us.venky.library.springweb.services

import org.springframework.stereotype.Service
import us.venky.library.springweb.entities.Library
import us.venky.library.springweb.repository.LibraryRepository
import java.util.*

@Service
class LibraryService(private val repo: us.venky.library.springweb.repository.LibraryRepository) {
    fun get(): List<us.venky.library.springweb.entities.Library> {
        return repo.findAll()
    }
    fun get(id: UUID): us.venky.library.springweb.entities.Library? {
        return repo.findById(id).orElse(null)
    }
    fun create(library: us.venky.library.springweb.entities.Library): us.venky.library.springweb.entities.Library {
        return repo.save(library)
    }
    fun update(id: UUID, library: us.venky.library.springweb.entities.Library): us.venky.library.springweb.entities.Library?{
        val dept=get(id)
        dept?.let {return repo.save(us.venky.library.springweb.entities.Library(id, library.name, library.address))}
        return null;
    }
    fun delete(id:UUID): us.venky.library.springweb.entities.Library? {
        val department=get(id)
        department?.let { repo.deleteById(id) }
        return department
    }
}