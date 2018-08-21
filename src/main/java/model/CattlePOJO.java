package model;

import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

import java.util.*;

@NodeEntity(label = "Cattle")
public class CattlePOJO {

    private Long id;
    private String sex;
    @DateLong
    private Date birthday;
    private Double weight;
    @Relationship(type = "CHILD")
    private ArrayList<CattlePOJO> children;
    @Relationship(type = "CHILD", direction = Relationship.INCOMING)
    private ArrayList<CattlePOJO> parents;

    // Mandatory: No Arg Constructor
    public CattlePOJO() {}

    public CattlePOJO(String sex, Date birthday, Double weight) {
        this.sex = sex;
        this.birthday = birthday;
        this.weight = weight;
    }

    public void addChild(CattlePOJO child) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        this.children.add(child);
    }

    public List<Map<Character, CattlePOJO>> getSpouseAndChildren() {
        if (this.getChildren() == null) return null;

        List<Map<Character, CattlePOJO>> res = new ArrayList<>();

        for (CattlePOJO child : this.getChildren()) {
            Map<Character, CattlePOJO> map = new HashMap<>();
            map.put('c', child);
            for (CattlePOJO parent : child.getParents()) {
                if (parent != this) map.put('s', parent);
            }
            res.add(map);

        }

        return res;
    }

    @Override
    public String toString() {
        return "POJO<<<\n   id: " + this.id + "\n   sex: " + sex + "\n   birthday: " + birthday + "\n   weight: " + weight + "\n>>>";
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

    public ArrayList<CattlePOJO> getChildren() {
        return children;
    }

    public ArrayList<CattlePOJO> getParents() {
        return parents;
    }
}