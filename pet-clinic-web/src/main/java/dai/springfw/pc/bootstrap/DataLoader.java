package dai.springfw.pc.bootstrap;

import dai.springfw.pc.model.Owner;
import dai.springfw.pc.model.PetType;
import dai.springfw.pc.model.Vet;
import dai.springfw.pc.services.Map.OwnerServiceMap;
import dai.springfw.pc.services.Map.VetServiceMap;
import dai.springfw.pc.services.OwnerService;
import dai.springfw.pc.services.PetTypeService;
import dai.springfw.pc.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType pt1 = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType pt2 = petTypeService.save(cat);

        Owner owner1 = new Owner();
        //owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        //owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        ownerService.save(owner2);

        System.out.println("Loaded Owners.... ");

        Vet vet1 = new Vet();
        //vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        //vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);

        System.out.println("Loaded Vets....");



    }
}
