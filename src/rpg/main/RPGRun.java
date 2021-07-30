package rpg.main;

import rpg.character.Attributes;

public class RPGRun {

    public static void run() {
        run(new String[] {});
    }

    public static void run(String... args) {
        main(args);
    }

    public static void main(String[] args) {
        String[] priority = { "Dexterity", "Strength", "Wisdom", "Stamina", "Charisma", "Intelligence" };

        Attributes attributes = new Attributes();
        attributes.reorder(priority);
        System.out.println(attributes);
    }
}