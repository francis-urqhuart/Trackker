package Trakker.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by thufir on 03.04.16.
 */
@Entity
@SequenceGenerator(name = "activity", initialValue = 100, allocationSize = 1)
public class Activity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activity")
    private Long id;

    private String name, description;

    private Long memberId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        memberId = memberId;
    }
}
