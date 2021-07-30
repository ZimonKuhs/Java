package file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import program.ProgramUtility;

public class FileUtility {

    public static List<String> readLines(String filePath) {
        return readLines(new File(filePath));
    }

    public static List<String> readLines(File file) {
        List<String> content = Collections.emptyList();
        Path filePath = file.toPath();
        try {
            content = Files.readAllLines(filePath);
        } catch (IOException e) {
            ProgramUtility.error("Could not read file " + filePath.toString() + ": " + e.getMessage());
        }

        return content;
    }
}