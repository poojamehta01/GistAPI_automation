package helpers;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;

public class DataProvider {

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
    private static final String EMPTY_STRING = "";
    private static final HashMap<String, String> LANGUAGES = new HashMap<>();
    private static final SecureRandom random = new SecureRandom();
    private static final String[] possibleExt = {".rb", ".md", ".py", ".txt", ".java"};

    static {
        LANGUAGES.put("py", "Python");
        LANGUAGES.put("rb", "Ruby");
        LANGUAGES.put("md", "Markdown");
        LANGUAGES.put("txt", "Text");
        LANGUAGES.put("java", "Java");
    }

    public static String getRandomFileName() {
        return getRandomFileName(10);
    }

    public static String getRandomFileName(int length) {
        StringBuilder fileName = new StringBuilder();
        fileName.append(generateRandomString(length));
        fileName.append(possibleExt[random.nextInt(possibleExt.length - 1)]);
        return fileName.toString();
    }

    public static String getExtension(String fileName) {
        final String[] segments = fileName.split("\\.");
        return segments[segments.length - 1];
    }


    public static String getEmptyString() {
        return EMPTY_STRING;
    }

    public static String getRandomContent(int length) {
        return generateRandomString(length);
    }

    public static String getRandomContent() {
        return getRandomContent(20);
    }

    public static String getRandomDescription(int length) {
        return generateRandomString(length);
    }

    public static String getRandomDescription() {
        return getRandomDescription(20);
    }

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();
    }

    public static String getExpectedLanguage(String fileName) {
        return LANGUAGES.get(getExtension(fileName));
    }

    public static String getLargeString() {
        final char[] buffer = new char[1024 * 1024];
        Arrays.fill(buffer, 'f');
        return new String(buffer);
    }
}
