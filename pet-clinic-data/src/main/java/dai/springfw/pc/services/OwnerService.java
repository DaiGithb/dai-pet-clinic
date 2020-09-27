package dai.springfw.pc.services;

import dai.springfw.pc.model.Owner;

import java.util.Set;


public interface OwnerService {

    Owner findByLastName(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}