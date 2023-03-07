package edu.spring.offres.repositories

import edu.spring.offres.entities.Offre
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "offres", collectionResourceRel = "offres")
interface RestOffresResource: JpaRepository<Offre, Int> {
}