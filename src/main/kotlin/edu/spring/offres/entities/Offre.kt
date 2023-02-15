package edu.spring.offres.entities

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Lob
import jakarta.persistence.ManyToOne

@Entity
open class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: Int?=null

    @Column(length = 100, nullable = false)
    lateinit open var intitule:String

    @Lob
    open var description:String?=""

    open var nbPostes:Int=1

    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "idEntreprise")
    lateinit open var entreprise:Entreprise
}