package model;

import java.io.Serializable;
import java.util.Date;

public class Cattle implements Serializable {

    private String id;
    private String sex;
    private Date birthday;
    private Double weight;
    private String variety;
    private String father_id;
    private String mother_id;
    private String children_id;

    /** Constructors **/

    public Cattle() {
    }

    public Cattle(String id, String sex, Date birthday, Double weight, String variety, String father_id, String mother_id, String children_id) {
        this.id = id;
        this.sex = sex;
        this.birthday = birthday;
        this.weight = weight;
        this.variety = variety;
        this.father_id = father_id;
        this.mother_id = mother_id;
        this.children_id = children_id;
    }

    /** Getters and Setters */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getFather_id() {
        return father_id;
    }

    public void setFather_id(String father_id) {
        this.father_id = father_id;
    }

    public String getMother_id() {
        return mother_id;
    }

    public void setMother_id(String mother_id) {
        this.mother_id = mother_id;
    }

    public String getChildren_id() {
        return children_id;
    }

    public void setChildren_id(String children_id) {
        this.children_id = children_id;
    }

}

