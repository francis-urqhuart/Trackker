package Trakker.model;

import javax.persistence.*;

/**
 * Created by thufir on 03.04.16.
 */
@Entity
@SequenceGenerator(name = "entry", initialValue = 100, allocationSize = 1)
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entry")
    private Long id;


}
