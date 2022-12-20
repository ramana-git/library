package us.venky.library.springweb.repository

import org.springframework.data.jpa.repository.JpaRepository
import us.venky.library.springweb.entities.Member
import java.util.UUID

interface MemberRepository : JpaRepository<us.venky.library.springweb.entities.Member, UUID>