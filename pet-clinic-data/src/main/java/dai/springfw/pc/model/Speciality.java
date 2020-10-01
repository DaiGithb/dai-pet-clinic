package dai.springfw.pc.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
//@Builder
@Entity
@Table(name="Specialities")
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;

}
