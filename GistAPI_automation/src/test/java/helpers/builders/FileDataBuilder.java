package helpers.builders;

import models.File;
import models.FileProperties;

public class FileDataBuilder {
    private File file;
    private FileProperties fileProperties;

    public FileDataBuilder() {
        file = new File();
        fileProperties = new FileProperties();
        file.setFileProperties(fileProperties);
    }

    public FileDataBuilder createFile(String fileName) {
        file.setName(fileName);
        return this;
    }

    public FileDataBuilder WithContent(String content) {
        fileProperties.setContent(content);
        return this;
    }

    public File build() {
        return file;
    }
}
