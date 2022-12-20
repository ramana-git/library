package us.venky.library.springweb.services

import org.springframework.stereotype.Service
import us.venky.library.springweb.entities.Title
import us.venky.library.springweb.repository.TitleRepository
import java.util.*

@Service
class TitleService(private val repo: TitleRepository) {
    fun get(): List<Title> {
        return repo.findAll()
    }
    fun get(isbn:String): List<Title> {
        return repo.findByIsbn(isbn)
    }
    fun get(id: UUID): Title? {
        return repo.findById(id).orElse(null)
    }
    fun create(title: Title): Title {
        title.id=null
        return repo.save(title)
    }
    fun update(id: UUID, title: Title): Title?{
        val tit=get(id)
        tit?.let {title.id=id;return repo.save(title)}
        return null;
    }
    fun delete(id:UUID): Title? {
        val title=get(id)
        title?.let { repo.deleteById(id) }
        return title
    }
}