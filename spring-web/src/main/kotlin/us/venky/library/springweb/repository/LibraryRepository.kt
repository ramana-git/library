package us.venky.library.springweb.repository

import org.springframework.data.jpa.repository.JpaRepository
import us.venky.library.springweb.entities.Library
import java.util.UUID

interface LibraryRepository : JpaRepository<us.venky.library.springweb.entities.Library, UUID>