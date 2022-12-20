package us.venky.library.springweb.repository

import org.springframework.data.jpa.repository.JpaRepository
import us.venky.library.springweb.entities.Title
import java.util.UUID

interface TitleRepository : JpaRepository<us.venky.library.springweb.entities.Title, UUID>