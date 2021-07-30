package gaming.pokemon;

import gaming.main.JSONInterface;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PokemonList {
    private static final Map<String, Pokemon> pokemon = new HashMap<String, Pokemon>();
    private static boolean created = false;

    private PokemonList() {
        /* Non-instantiable. */
    }

    static {
        if (created) {
            throw new UnsupportedOperationException("Pok�mon list has already been created!");
        }
        JSONArray array = (JSONArray) JSONInterface
                .parse("D:\\Code\\Eclipse\\UnnecessaryUtilities\\gaming\\data\\pokemon.json").get("Pokemon");

        for (Object obj : array) {
            Pokemon mon = new Pokemon((JSONObject) obj);
            pokemon.put(mon.name(), mon);
        }

        created = true;

    }

    public static int amount() {
        return pokemon.size();
    }

    public static boolean exists(String name) {
        return pokemon.containsKey(name);
    }

    public static Pokemon get(String name) {
        if (!exists(name)) {
            throw new UnsupportedOperationException("No such Pokemon has been parsed: " + name + ".");
        }
        return pokemon.get(name);
    }

}