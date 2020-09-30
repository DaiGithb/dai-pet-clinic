package dai.springfw.pc.services.sdatajpa;

import dai.springfw.pc.model.Owner;
import dai.springfw.pc.repos.OwnerRepo;
import dai.springfw.pc.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerJpaService implements OwnerService {

    private final OwnerRepo ownerRepo;

    public OwnerJpaService(OwnerRepo ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepo.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findALL() {
        Set<Owner> owners = new HashSet<>();
        ownerRepo.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepo.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepo.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepo.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepo.deleteById(id);
    }
}
