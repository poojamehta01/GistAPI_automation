package helpers.builders;

import models.File;
import models.Files;
import models.requests.Gist;

import java.util.List;

public class GistDataBuilder {
    private Gist gist;
    private Files files;

    public GistDataBuilder() {
        gist = new Gist();
        files = new Files();
        gist.setFiles(files);
    }

    public GistDataBuilder withDescription(String description) {
        gist.setDescription(description);
        return this;
    }

    public GistDataBuilder withPublicity(boolean publicity) {
        gist.setPublicity(publicity);
        return this;
    }

    public GistDataBuilder withFile(File file) {
        files.addFileByName(file.getName(), file.getFileProperties());
        return this;
    }

    public GistDataBuilder withFiles(List<File> files1) {
        for (File f : files1) {
            files.addFileByName(f.getName(), f.getFileProperties());
        }
        return this;
    }

    public Gist build() {
        return gist;
    }
}
