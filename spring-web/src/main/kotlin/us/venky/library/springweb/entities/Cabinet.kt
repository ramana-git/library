package us.venky.library.springweb.entities

import jakarta.persistence.*
import java.util.UUID

@Entity(name="cabinets")
data class Cabinet(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id:UUID?,
    val name: String,
    @ManyToOne(fetch = FetchType.EAGER) @JoinTable(name="cabinets_room")
    val room: Room
)