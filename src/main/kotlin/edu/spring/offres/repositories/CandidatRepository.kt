package edu.spring.offres.repositories

import edu.spring.offres.entities.Candidat
import edu.spring.offres.entities.Formation
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CandidatRepository: CrudRepository<Candidat, Int> {
}