package edu.spring.offres.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class CandidatOffre {
    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "idCandidat")
    lateinit var candidat : Candidat

    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    lateinit var offre : Offre

    @Column(length = 100, nullable = false)
    lateinit open var actions : String
}