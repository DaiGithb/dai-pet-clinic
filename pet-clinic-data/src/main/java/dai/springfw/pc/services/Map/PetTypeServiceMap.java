package dai.springfw.pc.services.Map;

import dai.springfw.pc.model.PetType;
import dai.springfw.pc.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long>
        implements PetTypeService {

    @Override
    public Set<PetType> findALL() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }


}
