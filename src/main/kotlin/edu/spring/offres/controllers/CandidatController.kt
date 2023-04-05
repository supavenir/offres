package edu.spring.offres.controllers

import edu.spring.offres.entities.Formation
import edu.spring.offres.repositories.CandidatRepository
import edu.spring.offres.repositories.FormationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/candidat")
class CandidatController {
    @Autowired
    lateinit var candidatRepository : CandidatRepository;

    @Autowired
    lateinit var formationRepository : FormationRepository

    lateinit var formation : Formation

    @RequestMapping(path = ["","index"])
    fun indexListCandidat(model : ModelMap) : String
    {
        model["candidats"] = candidatRepository.findAll();
        return "/candidat/index";
    }

    @GetMapping("/getByFormation")
    fun listCandidatByFormation(model: ModelMap) : String {
        model["formations"] = formationRepository.findAll();
        return "/candidat/index";
    }
}