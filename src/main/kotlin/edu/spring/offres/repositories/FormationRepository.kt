package edu.spring.offres.repositories

import edu.spring.offres.entities.Formation
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FormationRepository : CrudRepository<Formation,Int> {
}