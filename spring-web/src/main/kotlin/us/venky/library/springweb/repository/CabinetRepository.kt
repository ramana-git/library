package us.venky.library.springweb.repository

import org.springframework.data.jpa.repository.JpaRepository
import us.venky.library.springweb.entities.Cabinet
import java.util.UUID

interface CabinetRepository : JpaRepository<us.venky.library.springweb.entities.Cabinet, UUID> {
    abstract fun findByName(name: String): List<Cabinet>
    abstract fun findByRoom(room: UUID): List<Cabinet>
}