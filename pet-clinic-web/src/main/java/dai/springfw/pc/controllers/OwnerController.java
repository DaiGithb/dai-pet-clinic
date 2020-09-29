package dai.springfw.pc.controllers;

import dai.springfw.pc.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/owners","/owners/index","/owners/index.html"})
    public String listOwners(Model model){

        model.addAttribute("owners", ownerService.findALL());

        return "owners/index";
    }

    @RequestMapping("/owners/find")
    public String findOwners(){
        return "owners/index";
    }

}
