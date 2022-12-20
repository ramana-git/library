package us.venky.library.springweb.repository

import org.springframework.data.jpa.repository.JpaRepository
import us.venky.library.springweb.entities.Book
import java.util.UUID

interface BookRepository : JpaRepository<us.venky.library.springweb.entities.Book, UUID>