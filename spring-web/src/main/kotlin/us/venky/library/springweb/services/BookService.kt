package us.venky.library.springweb.services

import org.springframework.stereotype.Service
import us.venky.library.springweb.entities.Book
import us.venky.library.springweb.repository.BookRepository
import java.util.*
@Service
class BookService (private val repo: BookRepository, private val memberService: MemberService) {
    fun get(): List<Book> {
        return repo.findAll()
    }
    fun get(id: UUID): Book? {
        return repo.findById(id).orElse(null)
    }
    fun getByTitle(title: UUID): List<Book> {
        return repo.findByTitle(title)
    }
    fun create(book: Book): Book {
        book.id=null
        return repo.save(book)
    }
    fun update(id: UUID, book: Book): Book?{
        val bk=get(id)
        bk?.let {book.id=id;return repo.save(book)}
        return null
    }
    fun checkin(id: UUID): Book?{
        val book=get(id)
        book?.let {book.checkOut=null;book.member=null;return repo.save(book)}
        return null
    }
    fun checkout(id: UUID, mid: UUID): Book?{
        val book=get(id)
        val member=memberService.get(mid)
        if(book!=null && member!=null){
            book.member=member
            book.checkOut=Date()
            return repo.save(book)
        }
        return null
    }
    fun delete(id: UUID): Book? {
        val book=get(id)
        book?.let { repo.deleteById(id) }
        return book
    }
}