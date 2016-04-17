package Trakker.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by thufir on 17.04.16.
 */

@Entity
@SequenceGenerator(name = "memberprofile", initialValue = 100, allocationSize = 1)
public class MemberProfile implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="memberprofile")
    private Long id;
    private String basalInsulin;
    private String bolusInsulin;
    private int height;
    private int maxBloodGlucose;
    private int minBloodGlucose;
    private int targetBloodGlucose;
}
