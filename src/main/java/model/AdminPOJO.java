package model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "Admin")
public class AdminPOJO {

    private Long id;
    private String name;
    private String password;
    private String phone;
    private String position;

    // Mandatory: No Arg Constructor
    public AdminPOJO() {}


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
