package dai.springfw.pc.services.Map;

import dai.springfw.pc.model.Owner;
import dai.springfw.pc.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long id = 1L;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap( new PetServiceMap(),new PetTypeServiceMap());
        ownerServiceMap.save(Owner.builder().id(1L).build());
    }

    @Test
    void findALL() {
        Set<Owner> so = ownerServiceMap.findALL();
        assertEquals(1, so.size());
    }

    @Test
    void findById() {
        Owner o = ownerServiceMap.findById(id);
        assertEquals(id, o.getId());
    }

    @Test
    void save() {
        Long id = 2L;
        //Owner o = Owner.builder().id(id).build();
        Owner o = Owner.builder().firstName("David").build();
        Owner os = ownerServiceMap.save(o);
        //assertEquals(id, os.getId());
        assertNotNull(os);
        assertNotNull(os.getId());

    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(id);
        assertEquals(0, ownerServiceMap.findALL().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(id));
        assertEquals(0, ownerServiceMap.findALL().size());
    }

    @Test
    void findByLastName() {
        String ln = "Dai";
        Owner o = ownerServiceMap.save(Owner.builder().lastName("Dai").build());
        assertEquals(ln, ownerServiceMap.findByLastName(ln).getLastName());
        //verify(ownerServiceMap, times(1)).save();
    }
}