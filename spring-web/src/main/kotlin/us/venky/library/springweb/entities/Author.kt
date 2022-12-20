package us.venky.library.springweb.entities

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name="authors")
data class Author(
    @Id @GeneratedValue
    var id: UUID?,
    val firstName: String,
    val lastName: String,
    val address: String?
)