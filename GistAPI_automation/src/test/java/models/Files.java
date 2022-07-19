package models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Files {

    private Map<String, FileProperties> filesMap;

    public Files() {
        this.filesMap = new HashMap<>();
    }

    @JsonAnyGetter
    public Map<String, FileProperties> filesCollection() {
        return this.filesMap;
    }

    @JsonAnySetter
    public void addFileByName(String name, FileProperties fileProperties) {
        filesMap.put(name, fileProperties);
    }

    public FileProperties getFileByName(String fileName) {
        return filesCollection().get(fileName);
    }

    public boolean hasFileWithName(String fileName) {
        return filesCollection().containsKey(fileName);
    }
}

