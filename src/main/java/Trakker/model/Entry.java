package Trakker.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by thufir on 03.04.16.
 */
@Entity
@SequenceGenerator(name = "entry", initialValue = 100, allocationSize = 1)
public class Entry implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entry")
    private Long id;
    private String activityID;
    private int basalinsulin;
    private boolean beforeactivity;
    private boolean beforemeal;
    private int bolusinsulin;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdtimestamp;
    private String descactivity;
    private String descmeal;
    private String diaryID;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date entrydate;
    private String remark;
    private String memberID;
    private int valuebe;
    private int valuebloodglucose_mg_dl;
    private double valuebloodglucose_mmol;
    private int weight;

}
