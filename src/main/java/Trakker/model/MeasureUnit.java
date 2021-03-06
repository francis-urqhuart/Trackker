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
    private MeasureUnitTypes type;

    private String measureUnit;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MeasureUnitTypes getType() {
        return type;
    }

    public void setType(MeasureUnitTypes type) {
        this.type = type;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
