package dai.springfw.pc.controllers;

import dai.springfw.pc.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets","/vets/index"})
    public String listVets(Model model){

        model.addAttribute("vets", vetService.findALL());
        return "vets/index";
    }

    @RequestMapping("vets.html")
    public String findVets(){
        return "vets";
    }
}
