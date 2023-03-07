package edu.spring.offres.repositories

import edu.spring.offres.entities.Entreprise
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface EntrepriseRepository:CrudRepository<Entreprise,Int> {
    //TODO déterminer comment acceder à cette méthode via URl
    fun findByRs(rs:String):Entreprise?
}