package us.venky.library.springweb.repository

import org.springframework.data.jpa.repository.JpaRepository
import us.venky.library.springweb.entities.Building
import java.util.UUID

interface BuildingRepository : JpaRepository<us.venky.library.springweb.entities.Building, UUID>