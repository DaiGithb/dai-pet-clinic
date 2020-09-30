package dai.springfw.pc.repos;

import dai.springfw.pc.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepo extends CrudRepository<Pet, Long> {
}
