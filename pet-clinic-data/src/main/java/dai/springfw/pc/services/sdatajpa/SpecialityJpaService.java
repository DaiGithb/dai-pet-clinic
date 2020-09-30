package dai.springfw.pc.services.sdatajpa;

import dai.springfw.pc.model.Speciality;
import dai.springfw.pc.repos.SpecialityRepo;
import dai.springfw.pc.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialityJpaService implements SpecialityService {

    private final SpecialityRepo spRepo;

    public SpecialityJpaService(SpecialityRepo specialityRepo) {
        this.spRepo = specialityRepo;
    }

    @Override
    public Set<Speciality> findALL() {
        Set<Speciality> sps = new HashSet<>();
        spRepo.findAll().forEach(sps::add);
        return sps;
    }

    @Override
    public Speciality findById(Long id) {
        return spRepo.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return spRepo.save(object);
    }

    @Override
    public void delete(Speciality object) {
        spRepo.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        spRepo.deleteById(id);
    }
}
