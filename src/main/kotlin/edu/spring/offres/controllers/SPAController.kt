package edu.spring.offres.controllers

import edu.spring.offres.entities.Entreprise
import io.github.jeemv.springboot.vuejs.VueJS
import io.github.jeemv.springboot.vuejs.utilities.Http
import io.github.jeemv.springboot.vuejs.utilities.JsArray
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/spa")
class SPAController {

    @Autowired
    lateinit var vue:VueJS

    @ModelAttribute("vue")
    fun getVueInstance():VueJS=this.vue

    @RequestMapping(path = ["","/"])
    fun index():String{
        vue.addDataRaw("entreprises","[]")
        vue.addDataRaw("entreprise","{rs:''}")
        vue.addMethod("add",
            Http.post("/entreprises","entreprise",
            JsArray.add("this.entreprises","entreprise")+
                    "entreprise.rs='';"
            ),
            "entreprise")
        vue.onMounted(
            Http.get("/entreprises",Http.responseArrayToArray("this.entreprises","entreprises"))
        )
        return "/spa/index"
    }
}