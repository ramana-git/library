package us.venky.library.springweb.entities

import jakarta.persistence.*
import java.util.Date
import java.util.UUID

@Entity(name="books")
data class Book (
    @Id @GeneratedValue
    val id: UUID?,
    @ManyToOne
    val title: Title,
    @ManyToOne
    val rack: Rack,
    val checkOut: Date?,
    @ManyToOne(fetch = FetchType.EAGER)
    val member: Member?
)