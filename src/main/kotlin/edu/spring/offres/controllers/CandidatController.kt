package edu.spring.offres.controllers

import edu.spring.offres.repositories.CandidatRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/candidat")
class CandidatController {
    @Autowired
    lateinit var candidatRepository : CandidatRepository;

    @RequestMapping(path = ["","index"])
    fun indexListCandidat(model : ModelMap) : String
    {
        model["candidats"] = candidatRepository.findAll();
        return "/candidat/index";
    }

    @RequestMapping("/getByFormation/{id}")
    fun listCandidatByFormation(model: ModelMap, @PathVariable id : Int) : String {
        model["formation_candidat"] = candidatRepository.findByFormation(id)
        return "/candidat/index";
    }
}