package edu.spring.offres.controllers

import edu.spring.offres.entities.Entreprise
import edu.spring.offres.repositories.EntrepriseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.view.RedirectView
import java.util.*

@Controller
@RequestMapping("/entrep")
class EntrepriseController {

    @Autowired
    lateinit var entrepriseRepository: EntrepriseRepository

    @RequestMapping(path = ["","index"])
    fun indexAction(model:ModelMap):String{
        model["entreprises"]=entrepriseRepository.findAll()
        return "/entrep/index"
    }

    @GetMapping("/new")
    fun newAction(model:ModelMap):String{
        model["entrep"]=Entreprise()
        return "/entrep/form"
    }

    @PostMapping("/new")
    fun newSubmitAction(
        @ModelAttribute entreprise:Entreprise
    ):RedirectView{
        if(entrepriseRepository.findByRs(entreprise.rs) == null && entreprise.rs != "") entrepriseRepository.save(entreprise);
        return RedirectView("/entrep")
    }
}