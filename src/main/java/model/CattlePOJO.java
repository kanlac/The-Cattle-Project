package model;

import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.typeconversion.DateLong;
import org.neo4j.ogm.annotation.typeconversion.DateString;

import java.util.Date;
import java.util.Set;

@NodeEntity(label = "Cattle")
public class CattlePOJO {

    private Long id;
    private String sex;
    @DateLong
    private Date birthday;
    private Double weight;
    @Relationship(type = "CHILD")
    private Set<CattlePOJO> child;
    @Relationship(type = "CHILD", direction = Relationship.INCOMING)
    private Set<CattlePOJO> parent;

    // No Arg Constructor
    public CattlePOJO() {}

    @Override
    public String toString() {
        return "c_id: " + this.id + "\nsex: " + sex + "\nbirthday: " + birthday + "\nweight: " + weight;
    }

    /*** Getters and Setters ***/

    public Long getId() {
        return id;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Double getWeight() {
        return weight;
    }
}

