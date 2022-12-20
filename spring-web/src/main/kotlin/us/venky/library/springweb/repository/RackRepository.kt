package us.venky.library.springweb.repository

import org.springframework.data.jpa.repository.JpaRepository
import us.venky.library.springweb.entities.Rack
import java.util.UUID

interface RackRepository : JpaRepository<us.venky.library.springweb.entities.Rack, UUID> {
    abstract fun findByName(name: String): List<Rack>
    abstract fun findByCabinet(cabinet: UUID): List<Rack>
}