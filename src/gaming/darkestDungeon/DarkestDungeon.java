package gaming.darkestDungeon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class DarkestDungeon {
    private static final Random DIE = new Random();

    private static final String[] HEROES = { "Abomination", "Antiquarian", "Arbalest", "Bounty Hunter", "Crusader",
            "Flagellant", "Grave Robber", "Hellion", "Highwayman", "Houndmaster", "Jester", "Leper", "Man-at-Arms",
            "Musketeer", "Occultist", "Plague Doctor", "Shieldbreaker", "Vestal" };
    private static final int N_HEROES = HEROES.length;

    public List<String> pickClasses(int amount) {
        if (amount <= 0 || amount > N_HEROES) {
            throw new IllegalArgumentException(
                    "Number of heroes selected must be between 0 and " + HEROES.length + ".");
        }

        if (amount == N_HEROES) {
            return Collections.unmodifiableList(Arrays.asList(HEROES));
        }

        Set<Integer> taken = new HashSet<Integer>();
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < amount;) {
            int next = DIE.nextInt(N_HEROES);
            if (!taken.contains(next)) {
                ++i;
                taken.add(next);
                result.add(HEROES[next]);
            }
        }

        return Collections.unmodifiableList(result);
    }
}