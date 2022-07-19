package models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import models.Files;

public class Gist {
    private String description;
    private boolean publicity;
    private Files files;

    public Gist() {

    }

    @JsonProperty("files")
    public Files getFiles() {
        return this.files;
    }

    @JsonProperty("files")
    public void setFiles(Files files) {
        this.files = files;
    }

    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getPublicity() {
        return publicity;
    }

    @JsonProperty("public")
    public void setPublicity(boolean publicity) {
        this.publicity = publicity;
    }
}
