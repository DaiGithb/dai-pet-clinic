package dai.springfw.pc.repos;

import dai.springfw.pc.model.Pet;
import dai.springfw.pc.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepo extends CrudRepository<PetType, Long> {
}
