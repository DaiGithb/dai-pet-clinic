package dai.springfw.pc.model;

import dai.springfw.pc.model.Person;

import java.util.Set;

public class Vet extends Person {

    private Set<Speciality> speciality;

    public Set<Speciality> getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Set<Speciality> speciality) {
        this.speciality = speciality;
    }
}
