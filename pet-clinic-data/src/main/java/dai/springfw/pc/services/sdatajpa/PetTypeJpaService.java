package dai.springfw.pc.services.sdatajpa;

import dai.springfw.pc.model.PetType;
import dai.springfw.pc.model.Vet;
import dai.springfw.pc.repos.PetTypeRepo;
import dai.springfw.pc.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeJpaService implements PetTypeService {

    private final PetTypeRepo petTypeRepo;

    public PetTypeJpaService(PetTypeRepo petTypeRepo) {
        this.petTypeRepo = petTypeRepo;
    }

    @Override
    public Set<PetType> findALL() {
        Set<PetType> pts = new HashSet<>();
        petTypeRepo.findAll().forEach(pts::add);
        return pts;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepo.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepo.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepo.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepo.deleteById(id);
    }
}
