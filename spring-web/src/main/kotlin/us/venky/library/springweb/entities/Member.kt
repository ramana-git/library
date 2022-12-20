package us.venky.library.springweb.entities

import jakarta.persistence.*
import java.util.Date
import java.util.UUID

@Entity
@Table(name="members")
data class Member(
    @Id @GeneratedValue
    var id: UUID?,
    val firstName: String,
    val lastName: String,
    val address: String,
    val email: String,
    var joinDate: Date?,
    var verified: Boolean?=false,
)