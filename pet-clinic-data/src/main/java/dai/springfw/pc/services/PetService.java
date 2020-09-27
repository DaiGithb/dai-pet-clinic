package dai.springfw.pc.services;

import dai.springfw.pc.model.Owner;
import dai.springfw.pc.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
