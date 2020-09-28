package dai.springfw.pc.services.Map;

import dai.springfw.pc.model.Speciality;
import dai.springfw.pc.services.SpecialityService;

import java.util.Set;

public class SpecialityServiceMap extends AbstractMapService<Speciality, Long>
        implements SpecialityService {

    @Override
    public Set<Speciality> findALL() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
