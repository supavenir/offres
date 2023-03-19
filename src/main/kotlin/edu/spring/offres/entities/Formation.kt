package edu.spring.offres.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToMany

@Entity
class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var idFormation : Int? = null

    @Column(length = 255, nullable = false)
    open lateinit var libelle : String

    @ManyToMany
    open var offres = mutableSetOf<Offre>()
}