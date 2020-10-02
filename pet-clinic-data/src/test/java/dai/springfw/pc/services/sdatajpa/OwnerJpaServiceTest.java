package dai.springfw.pc.services.sdatajpa;

import dai.springfw.pc.model.Owner;
import dai.springfw.pc.repos.OwnerRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    @InjectMocks
    OwnerJpaService ojpas;
    @Mock
    OwnerRepo ownerRepo;
    String lname;
    Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).lastName(lname).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepo.findByLastName(any())).thenReturn(owner);
        Owner o = ojpas.findByLastName(lname);
        assertEquals(lname, o.getLastName());
        verify(ownerRepo, times(1)).findByLastName(any());
    }

    @Test
    void findALL() {
        Set<Owner> s = new HashSet<>();
        s.add(owner);
        when(ownerRepo.findAll()).thenReturn(s);
        Set<Owner> o = ojpas.findALL();
        assertEquals(1, o.size());
    }

    @Test
    void findById() {
        when(ownerRepo.findById(anyLong())).thenReturn(Optional.of(owner));
        Owner o = ojpas.findById(1L);
        assertEquals(1, o.getId());
        verify(ownerRepo, times(1)).findById(any());
    }

    @Test
    void save() {
        when(ownerRepo.save(any())).thenReturn(owner);
        Owner o2s = Owner.builder().id(2L).lastName(lname).build();
        Owner o = ojpas.save(o2s);
        assertEquals(1, o.getId());
        verify(ownerRepo, times(1)).save(any());
    }

    @Test
    void delete() {
        ojpas.delete(owner);
        verify(ownerRepo).delete(any());
    }

    @Test
    void deleteById() {
    }
}