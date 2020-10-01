package dai.springfw.pc.services.Map;

import dai.springfw.pc.model.Vet;
import dai.springfw.pc.model.Visit;
import dai.springfw.pc.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitServiceMap extends CommonMapService<Visit, Long>
        implements VisitService {


    @Override
    public Set<Visit> findALL() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.findById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit visit) {

        if (visit.getPet() == null || visit.getPet().getOwner() == null ||
                visit.getPet().getId() == null ||
                visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit!!");
        }

        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
