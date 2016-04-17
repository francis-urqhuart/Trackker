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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityID() {
        return activityID;
    }

    public void setActivityID(String activityID) {
        this.activityID = activityID;
    }

    public int getBasalinsulin() {
        return basalinsulin;
    }

    public void setBasalinsulin(int basalinsulin) {
        this.basalinsulin = basalinsulin;
    }

    public boolean isBeforeactivity() {
        return beforeactivity;
    }

    public void setBeforeactivity(boolean beforeactivity) {
        this.beforeactivity = beforeactivity;
    }

    public boolean isBeforemeal() {
        return beforemeal;
    }

    public void setBeforemeal(boolean beforemeal) {
        this.beforemeal = beforemeal;
    }

    public int getBolusinsulin() {
        return bolusinsulin;
    }

    public void setBolusinsulin(int bolusinsulin) {
        this.bolusinsulin = bolusinsulin;
    }

    public Date getCreatedtimestamp() {
        return createdtimestamp;
    }

    public void setCreatedtimestamp(Date createdtimestamp) {
        this.createdtimestamp = createdtimestamp;
    }

    public String getDescactivity() {
        return descactivity;
    }

    public void setDescactivity(String descactivity) {
        this.descactivity = descactivity;
    }

    public String getDescmeal() {
        return descmeal;
    }

    public void setDescmeal(String descmeal) {
        this.descmeal = descmeal;
    }

    public String getDiaryID() {
        return diaryID;
    }

    public void setDiaryID(String diaryID) {
        this.diaryID = diaryID;
    }

    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public int getValuebe() {
        return valuebe;
    }

    public void setValuebe(int valuebe) {
        this.valuebe = valuebe;
    }

    public int getValuebloodglucose_mg_dl() {
        return valuebloodglucose_mg_dl;
    }

    public void setValuebloodglucose_mg_dl(int valuebloodglucose_mg_dl) {
        this.valuebloodglucose_mg_dl = valuebloodglucose_mg_dl;
    }

    public double getValuebloodglucose_mmol() {
        return valuebloodglucose_mmol;
    }

    public void setValuebloodglucose_mmol(double valuebloodglucose_mmol) {
        this.valuebloodglucose_mmol = valuebloodglucose_mmol;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", activityID='" + activityID + '\'' +
                ", basalinsulin=" + basalinsulin +
                ", beforeactivity=" + beforeactivity +
                ", beforemeal=" + beforemeal +
                ", bolusinsulin=" + bolusinsulin +
                ", createdtimestamp=" + createdtimestamp +
                ", descactivity='" + descactivity + '\'' +
                ", descmeal='" + descmeal + '\'' +
                ", diaryID='" + diaryID + '\'' +
                ", entrydate=" + entrydate +
                ", remark='" + remark + '\'' +
                ", memberID='" + memberID + '\'' +
                ", valuebe=" + valuebe +
                ", valuebloodglucose_mg_dl=" + valuebloodglucose_mg_dl +
                ", valuebloodglucose_mmol=" + valuebloodglucose_mmol +
                ", weight=" + weight +
                '}';
    }
}
