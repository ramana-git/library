package us.venky.library.springweb.entities

import jakarta.persistence.*
import java.util.UUID

@Entity(name="rooms")
data class Room(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id:UUID?,
    val name: String,
    @ManyToOne(fetch = FetchType.EAGER)
    val building: Building
)