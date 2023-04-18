package edu.spring.offres.repositories

import edu.spring.offres.entities.Offre
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OffreRepository:CrudRepository<Offre,Int> {
}