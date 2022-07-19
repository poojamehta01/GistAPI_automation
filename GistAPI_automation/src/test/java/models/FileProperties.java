package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileProperties {
    private String content;
    private String fileName;
    private String type;
    private String language;
    private String raw_url;
    private Float size;
    private Boolean truncated;

    public FileProperties(String content) {
        this.content = content;
    }

    public FileProperties() {
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("filename")
    public String getFileName() {
        return fileName;
    }

    @JsonProperty("filename")
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("raw_url")
    public String getRaw_url() {
        return raw_url;
    }

    @JsonProperty("raw_url")
    public void setRaw_url(String raw_url) {
        this.raw_url = raw_url;
    }

    @JsonProperty("size")
    public Float getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Float size) {
        this.size = size;
    }

    @JsonProperty("truncated")
    public Boolean getTruncated() {
        return truncated;
    }

    @JsonProperty("truncated")
    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
    }
}
