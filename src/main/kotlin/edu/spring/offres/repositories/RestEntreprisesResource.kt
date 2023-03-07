package edu.spring.offres.repositories

import edu.spring.offres.entities.Entreprise
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "entreprises", path = "entreprises")
interface RestEntreprisesResource:JpaRepository<Entreprise,Int> {
    //TODO déterminer comment accéder à cette méthode via URL
    fun findByRs(rs:String):Entreprise?
}