package Trakker.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by thufir on 13.03.16.
 */

@Entity
@SequenceGenerator(name = "diary", initialValue = 100, allocationSize = 1)
public class Diary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diary")
    private Long id;

    @NotNull
    @Size(min = 6, max = 25)
    private String name;

    @NotNull
    private Long ownerID;

    @NotNull
    private boolean defaultDiary;


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

    public Long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Long ownerID) {
        this.ownerID = ownerID;
    }

    public boolean isDefaultDiary() {
        return defaultDiary;
    }

    public void setDefaultDiary(boolean defaultDiary) {
        this.defaultDiary = defaultDiary;
    }
}
