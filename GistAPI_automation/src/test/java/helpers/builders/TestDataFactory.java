package helpers.builders;

public class TestDataFactory {
    public static FileDataBuilder getFileDataBuilder() {
        return new FileDataBuilder();
    }

    public static GistDataBuilder getGistBuilder() {
        return new GistDataBuilder();
    }
}

