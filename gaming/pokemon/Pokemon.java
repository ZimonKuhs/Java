package pokemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.simple.JSONObject;

public class Pokemon {
    public static final int MAX_MOVES = 4;
    private String name;
    private List<Move> moves;

    @SuppressWarnings("unchecked")
    public Pokemon(JSONObject obj) {
        name = (String) obj.get("Name");

        moves = new ArrayList<Move>();
        for (String moveName : (List<String>) obj.get("Moves")) {
            moves.add(Moves.get(moveName));
        }

        checkMoves(moves);
        moves = Collections.unmodifiableList(moves);
    }

    private void checkMoves(List<Move> moves) {
        int nMoves = moves.size();
        if (nMoves <= 0 || nMoves > MAX_MOVES) {
            throw new IllegalStateException("Illegal Pok�mon " + name
                    + " found: number of moves has to be [1, 4], was " + nMoves
                    + ".");
        }
    }

    public List<Move> moves() {
        return moves;
    }

    public String name() {
        return name;
    }

}
