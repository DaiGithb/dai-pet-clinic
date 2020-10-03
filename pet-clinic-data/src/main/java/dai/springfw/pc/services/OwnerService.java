package dai.springfw.pc.services;

import dai.springfw.pc.model.Owner;

import java.util.List;
import java.util.Set;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
