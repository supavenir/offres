package edu.spring.offres.controllers

import edu.spring.offres.entities.Entreprise
import edu.spring.offres.entities.Offre
import edu.spring.offres.repositories.OffreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/offers")
class OffreController {

    @Autowired
    lateinit var offreRepository: OffreRepository

    @RequestMapping(path = ["","/"])
    @ResponseBody
    fun indexAction():String{
        addTempOffre("Stagiaire en informatique","St-James")
        return ""
    }

    fun addTempOffre(intitule:String,rs:String){
        val offre=Offre()
        val entreprise=Entreprise()
        offre.intitule=intitule
        entreprise.rs=rs
        offre.entreprise=entreprise
        offreRepository.save(offre)
    }
}