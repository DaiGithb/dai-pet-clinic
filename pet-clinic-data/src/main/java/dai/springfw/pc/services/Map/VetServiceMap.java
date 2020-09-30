package dai.springfw.pc.services.Map;


import dai.springfw.pc.model.Speciality;
import dai.springfw.pc.model.Vet;
import dai.springfw.pc.services.SpecialityService;
import dai.springfw.pc.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends CommonMapService<Vet, Long>
        implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findALL() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {

        if (object != null) {
            if (object.getSpeciality() != null) {
                object.getSpeciality().forEach(speciality -> {
                    if(speciality.getId() == null) {
                        Speciality savedSpeciality = specialityService.save(speciality);
                        speciality.setId(savedSpeciality.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }


}


