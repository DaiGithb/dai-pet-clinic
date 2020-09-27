package dai.springfw.pc.services;

import dai.springfw.pc.model.Owner;
import dai.springfw.pc.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();

}
