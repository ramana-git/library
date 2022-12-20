package us.venky.library.springweb.entities

import jakarta.persistence.*
import java.util.UUID

@Entity(name="titles")
data class Title (
    @Id @GeneratedValue
    val id: UUID?,
    val title: String,
    val isbn: String,
    val isbn10: String?,
    val publisher: String?,
    val year: Int?,
    @ManyToMany(fetch = FetchType.EAGER) @JoinTable(name="titles_authors")
    val authors: List<Author>
)