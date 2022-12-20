package us.venky.library.springweb.entities

import jakarta.persistence.*
import java.util.UUID

@Entity(name="buildings")
data class Building(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id:UUID?,
    val name: String,
    val address: String,
    val city: String,
    val state: String,
    val zip: String,
    @ManyToOne(fetch = FetchType.EAGER) @JoinTable(name="buildings_library")
    val library: Library
)