package edu.spring.offres.repositories

import edu.spring.offres.entities.Entreprise
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "entreprises", path = "entreprises")
interface RestEntreprisesRessource:JpaRepository<Entreprise, Int> {
}