package us.venky.library.springweb.entities

import jakarta.persistence.*
import java.util.UUID

@Entity(name="racks")
data class Rack(
    @Id @GeneratedValue
    var id:UUID?,
    val name: String?,
    @ManyToOne
    val cabinet: Cabinet,
)