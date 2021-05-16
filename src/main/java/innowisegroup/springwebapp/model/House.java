package innowisegroup.springwebapp.model;


import lombok.*;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
@Builder
public class House extends RealEstate {

    private String houseType;
    private double landArea;

}
