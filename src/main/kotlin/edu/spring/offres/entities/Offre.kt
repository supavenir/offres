package edu.spring.offres.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
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
    @RestResource(exported = false,rel="entreprise",path="entreprise")
    lateinit open var entreprise:Entreprise

    @ManyToMany(mappedBy = "offres", cascade = [CascadeType.ALL])
    open val formations = mutableSetOf<Formation>()

    @OneToMany(mappedBy = "offre")
    open val offreAssociation = mutableSetOf<CandidatOffre>()
}