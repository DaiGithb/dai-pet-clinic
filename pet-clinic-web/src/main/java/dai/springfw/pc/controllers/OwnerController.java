package dai.springfw.pc.controllers;

import dai.springfw.pc.model.Owner;
import dai.springfw.pc.model.Pet;
import dai.springfw.pc.repos.OwnerRepo;
import dai.springfw.pc.repos.VisitRepo;
import dai.springfw.pc.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class OwnerController {

    private final OwnerService ownerService;
    private final OwnerRepo owners;
    private VisitRepo visits;

    public OwnerController(OwnerService ownerService, OwnerRepo owners, VisitRepo visits) {
        this.ownerService = ownerService;
        this.owners = owners;
        this.visits = visits;
    }

    @RequestMapping({"/owners","/owners/index","/owners/index.html"})
    public String listOwners(Model model){

        Set<Owner> owners =  ownerService.findALL();
        model.addAttribute("owners", owners);
        //model.addAttribute("owners", ownerService.findALL());

        return "owners/index";
    }

    @RequestMapping("/owners/find")
    public String findOwners(){
        return "owners/index";
    }


    @GetMapping("/owners/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
//        Owner owner = this.owners.findById(ownerId);
//        for (Pet pet : owner.getPets()) {
//            pet.setVisitsInternal(visits.findByPetId(pet.getId()));
//        }
//        mav.addObject(owner);
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

}
