package model;

import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NodeEntity(label = "Cattle")
public class CattlePOJO {

    private Long id;
    private String sex;
    @DateLong
    private Date birthday;
    private Double weight;
    @Relationship(type = "CHILD")
    private Set<CattlePOJO> children;
    @Relationship(type = "CHILD", direction = Relationship.INCOMING)
    private Set<CattlePOJO> parents;

    // Mandatory: No Arg Constructor
    public CattlePOJO() {}

    public CattlePOJO(String sex, Date birthday, Double weight) {
        this.sex = sex;
        this.birthday = birthday;
        this.weight = weight;
    }

    public void addChild(CattlePOJO child) {
        if (this.children == null) {
            this.children = new HashSet<CattlePOJO>();
        }
        this.children.add(child);
    }

    @Override
    public String toString() {
        return "id: " + this.id + "\nsex: " + sex + "\nbirthday: " + birthday + "\nweight: " + weight;
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

