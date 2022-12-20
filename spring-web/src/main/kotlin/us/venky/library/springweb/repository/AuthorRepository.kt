package us.venky.library.springweb.repository

import org.springframework.data.jpa.repository.JpaRepository
import us.venky.library.springweb.entities.Author
import java.util.UUID

interface AuthorRepository : JpaRepository<us.venky.library.springweb.entities.Author, UUID>