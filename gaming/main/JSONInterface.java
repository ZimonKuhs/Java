package main;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import program.ProgramUtility;

public final class JSONInterface {

    private JSONInterface() {
        /* Non-instantiable. */
    }

    public static JSONObject parse(String fileName) {
        Object obj = null;
        try {
            obj = (JSONObject) new JSONParser().parse(new FileReader(fileName));

        } catch (IOException | ParseException e) {
            ProgramUtility.error(e.getMessage());
        }

        return (JSONObject) obj;
    }

}