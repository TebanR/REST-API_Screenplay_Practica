package co.com.practice.util.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    private static final String PATH_GENERAL_JSON = "src/main/resources/jsons/";

    public static String getJsonFromFile(String fileRoute) throws IOException {
        return new String(Files.readAllBytes(Paths.get(PATH_GENERAL_JSON + fileRoute)));
    }
}
