package dai.springfw.pc.services.sdatajpa;

import dai.springfw.pc.model.Pet;
import dai.springfw.pc.model.PetType;
import dai.springfw.pc.repos.PetRepo;
import dai.springfw.pc.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetJpaService implements PetService {

    private final PetRepo petRepo;

    public PetJpaService(PetRepo petRepo) {
        this.petRepo = petRepo;
    }

    @Override
    public Set<Pet> findALL() {
        Set<Pet> pets = new HashSet<>();
        petRepo.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return petRepo.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepo.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepo.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petRepo.deleteById(id);
    }
}
