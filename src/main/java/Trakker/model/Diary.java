package Trakker.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by thufir on 13.03.16.
 */

@Entity
public class Diary implements Serializable {

    @Id
    private Long id;

    @NotNull
    @Size(min = 6, max = 25)
    private String name;

    @NotNull
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Member owner;

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

    public Member getOwner() {
        return owner;
    }

    public void setOwner(Member owner) {
        this.owner = owner;
    }

    public boolean isDefaultDiary() {
        return defaultDiary;
    }

    public void setDefaultDiary(boolean defaultDiary) {
        this.defaultDiary = defaultDiary;
    }
}
