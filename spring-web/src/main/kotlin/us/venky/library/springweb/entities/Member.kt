package us.venky.library.springweb.entities

import jakarta.persistence.*
import java.util.Date
import java.util.UUID

@Entity
@Table(name="members")
data class Member(
    @Id @GeneratedValue
    val id: UUID?,
    val firstName: String,
    val lastName: String,
    val address: String,
    val email: String,
    val joinDate: Date?,
    val verified: Boolean?=false,
    val active: Boolean?=false
)