package edu.spring.offres.entities

import jakarta.persistence.*

@Entity
class Referent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: Int?=null

    @Column(length = 100, nullable = false)
    lateinit open var nom:String

    @ManyToMany()
    open val secteurs= mutableSetOf<Secteur>()
}