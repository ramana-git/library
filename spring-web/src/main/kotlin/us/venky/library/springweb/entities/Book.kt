package us.venky.library.springweb.entities

import jakarta.persistence.*
import java.util.Date
import java.util.UUID

@Entity(name="books")
data class Book (
    @Id @GeneratedValue
    var id: UUID?,
    @ManyToOne
    val title: Title,
    @ManyToOne
    val rack: Rack,
    var checkOut: Date?,
    @ManyToOne(fetch = FetchType.EAGER)
    var member: Member?
)