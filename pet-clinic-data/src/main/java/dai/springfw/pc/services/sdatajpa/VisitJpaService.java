package dai.springfw.pc.services.sdatajpa;

import dai.springfw.pc.model.Vet;
import dai.springfw.pc.model.Visit;
import dai.springfw.pc.repos.VisitRepo;
import dai.springfw.pc.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitJpaService implements VisitService {

    private final VisitRepo vsRepo;

    public VisitJpaService(VisitRepo vsRepo) {
        this.vsRepo = vsRepo;
    }

    @Override
    public Set<Visit> findALL() {
        Set<Visit> vsts = new HashSet<>();
        vsRepo.findAll().forEach(vsts::add);
        return vsts;
    }

    @Override
    public Visit findById(Long id) {
        return vsRepo.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return vsRepo.save(object);
    }

    @Override
    public void delete(Visit object) {
        vsRepo.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vsRepo.deleteById(id);
    }
}
