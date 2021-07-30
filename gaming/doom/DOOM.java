package doom;

import java.io.File;
import java.util.List;

import file.FileUtility;

public class DOOM {

    private static final String FILE = "D:\\Games\\DOOM\\Top 100 WADS.txt";

    public String createList() {
        List<String> lines = FileUtility.readLines(new File(FILE));
        StringBuilder string = new StringBuilder();

        for (String line : lines) {
            String[] parts = line.split("-");
            if (parts.length == 1) {
                continue;
            }

            string.append(parts[0].trim() + "\n");
        }

        return string.toString();
    }

}
