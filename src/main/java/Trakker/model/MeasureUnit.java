package Trakker.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by thufir on 17.04.16.
 */

@Entity
@SequenceGenerator(name = "measureunit", initialValue = 100, allocationSize = 1)
public class MeasureUnit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "measureunit")
    private Long id;

    @Enumerated(EnumType.STRING)
    private MeasureUnitTypes mut;

    private String measureUnit;

    private String description;

}
