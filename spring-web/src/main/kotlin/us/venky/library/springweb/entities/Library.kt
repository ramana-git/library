package us.venky.library.springweb.entities

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name="libraries")
data class Library (
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID?,
    val name: String,
    val address: String?
)