package us.venky.library.springweb.services

import org.springframework.stereotype.Service
import us.venky.library.springweb.entities.Member
import us.venky.library.springweb.repository.MemberRepository
import java.util.*

@Service
class MemberService(private val repo: MemberRepository) {
    fun get(): List<Member> {
        return repo.findAll()
    }
    fun get(lastName:String): List<Member> {
        return repo.findByLastName(lastName)
    }
    fun get(id: UUID): Member? {
        return repo.findById(id).orElse(null)
    }
    fun create(member: Member): Member {
        member.id=null
        return repo.save(member)
    }
    fun update(id: UUID, member: Member): Member?{
        val mem=get(id)
        mem?.let {member.id=id;return repo.save(member)}
        return null;
    }
    fun update(id: UUID, joinDate: Date): Member?{
        val member=get(id)
        member?.let {member.joinDate=joinDate;return repo.save(member)}
        return null;
    }
    fun update(id: UUID, verified: Boolean): Member?{
        val member=get(id)
        member?.let {member.verified=verified;return repo.save(member)}
        return null;
    }
    fun delete(id:UUID): Member? {
        val member=get(id)
        member?.let { repo.deleteById(id) }
        return member
    }
}