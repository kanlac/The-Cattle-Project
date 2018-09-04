package model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

import java.util.Date;

@NodeEntity(label = "Post")
public class PostPOJO {

    private Long id;
    private String title;
    @DateLong
    private Date date;
    private String content;

    // Mandatory: No Arg Constructor
    public PostPOJO() {}

    /*** Getters and Setters ***/

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }
}
