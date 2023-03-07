package edu.spring.offres.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Lob
import jakarta.persistence.ManyToOne
import org.springframework.data.rest.core.annotation.RestResource

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

    @ManyToOne()
    @JoinColumn(name = "idEntreprise")
    @JsonBackReference
    @RestResource(exported = false, rel="entreprise", path="entreprise")
    lateinit open var entreprise:Entreprise
}