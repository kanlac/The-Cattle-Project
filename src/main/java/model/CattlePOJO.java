package model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class CattlePOJO {
    private String c_id;
    private String sex;
    private String birthday;
    private String weight;


    public CattlePOJO(String c_id, String sex, String birthday, String weight) {
        this.c_id = c_id;
        this.sex = sex;
        this.birthday = birthday;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "c_id: " + this.c_id + "\nsex: " + sex + "\nbirthday: " + birthday + "\nweight: " + weight;
    }

    @Relationship(type = "CHILD")
    private CattlePOJO child;
}

