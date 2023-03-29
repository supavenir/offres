package edu.spring.offres.repositories

import edu.spring.offres.entities.Candidat
import edu.spring.offres.entities.Formation
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CandidatRepository: CrudRepository<Candidat, Int> {
    @Query("SELECT * FROM \"formation\" INNER JOIN \"formation_offres\" ON \"formation\".\"id_formation\"= \"formation_offres\".\"formations_id_formation\" INNER JOIN \"offre\" ON \"offre\".\"id\" = \"formation_offres\".\"offres_id\" INNER JOIN \"candidat_offre\" ON \"candidat_offre\".\"offre_id\" = \"offre\".\"id\" INNER JOIN \"candidat\" ON \"candidat\".\"id_candidat\" = \"candidat_offre\".\"candidat_id_candidat\" WHERE \"candidat\".\"id_candidat\" = :idCandidat ", nativeQuery = true)
    fun findByFormation(@Param("idCandidat") idCandidat : Int) : List<Formation>
}