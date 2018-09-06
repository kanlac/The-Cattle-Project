package model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "Image")
public class ImagePOJO {

    private Long id;
    private String filename;
    private String description;

    // Mandatory: No Arg Constructor
    public ImagePOJO() {}

    /*** Getters and Setters ***/

    public Long getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public String getDescription() {
        return description;
    }
}
