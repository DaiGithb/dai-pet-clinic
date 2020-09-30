package dai.springfw.pc.repos;

import dai.springfw.pc.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepo extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
}
