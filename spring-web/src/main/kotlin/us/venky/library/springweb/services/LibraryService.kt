package us.venky.library.springweb.services

import org.springframework.stereotype.Service
import us.venky.library.springweb.entities.Library
import us.venky.library.springweb.repository.LibraryRepository
import java.util.*

@Service
class LibraryService(private val repo: LibraryRepository) {
    fun get(): List<Library> {
        return repo.findAll()
    }
    fun get(id: UUID): Library? {
        return repo.findById(id).orElse(null)
    }
    fun create(library: Library): Library {
        library.id=null
        return repo.save(library)
    }
    fun update(id: UUID, library: Library): Library?{
        val lib=get(id)
        lib?.let {lib.id=id;return repo.save(lib)}
        return null;
    }
    fun delete(id:UUID): Library? {
        val library=get(id)
        library?.let { repo.deleteById(id) }
        return library
    }
}