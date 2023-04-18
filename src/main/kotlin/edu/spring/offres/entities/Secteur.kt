package edu.spring.offres.entities

import jakarta.persistence.*

@Entity
class Secteur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: Int?=null

    @Column(length = 100, nullable = false)
    lateinit open var nom:String

    @ManyToMany(mappedBy = "secteurs", cascade = [CascadeType.ALL])
    open val referents= mutableSetOf<Referent>()
}