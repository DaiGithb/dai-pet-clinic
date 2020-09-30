package dai.springfw.pc.services.sdatajpa;

import dai.springfw.pc.model.Vet;
import dai.springfw.pc.repos.VetRepo;
import dai.springfw.pc.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetJpaService implements VetService {

    private final VetRepo vetRepo;

    public VetJpaService(VetRepo vetRepo) {
        this.vetRepo = vetRepo;
    }

    @Override
    public Set<Vet> findALL() {
        Set<Vet> vets = new HashSet<>();
        vetRepo.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepo.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepo.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepo.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepo.deleteById(id);
    }
}
