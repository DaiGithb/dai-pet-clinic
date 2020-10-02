package dai.springfw.pc.controllers;

import dai.springfw.pc.model.Owner;
import dai.springfw.pc.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.data.repository.util.ClassUtils.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService os;
    @InjectMocks
    OwnerController oc;
    Set<Owner> owners;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        Owner o = Owner.builder().id(1L).lastName("Dai").build();
        owners.add(o);
        o = Owner.builder().id(2L).lastName("Dais").build();
        owners.add(o);

        mockMvc = MockMvcBuilders.standaloneSetup(oc).build();
    }

    @Test
    void listOwners() throws Exception {
        when(os.findALL()).thenReturn(owners);
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"));
        //assertEquals("owners/index", oc.findOwners());
        verifyZeroInteractions(os);
    }

    @Test
    void showOwners() throws Exception {
        when(os.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());
        mockMvc.perform(get("/owners/123"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                //.andExpect(model().attribute("owner", hasProperty("id", is(1L))))
                .andExpect(model().attributeExists("owner"));
    }

}