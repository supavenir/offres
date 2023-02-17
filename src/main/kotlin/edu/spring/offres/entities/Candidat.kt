package edu.spring.offres.entities

import jakarta.persistence.*

@Entity
open class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var idCandidat : Int? = null;

    @Column(length = 80, nullable = false)
    open lateinit var prenom: String

    @Column(length = 80, nullable = false)
    open lateinit var nom: String
}