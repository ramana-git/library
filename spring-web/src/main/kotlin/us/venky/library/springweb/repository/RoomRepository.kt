package us.venky.library.springweb.repository

import org.springframework.data.jpa.repository.JpaRepository
import us.venky.library.springweb.entities.Room
import java.util.UUID

interface RoomRepository : JpaRepository<us.venky.library.springweb.entities.Room, UUID> {
    abstract fun findByName(name: String): List<Room>
}