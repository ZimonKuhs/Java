package main;

import java.util.Arrays;

import darkestDungeon.DarkestDungeon;
import doom.DOOM;

public class Run {

    public static void main(String[] args) {
        createDOOMList();
    }

    private static void createDOOMList() {
        String result = new DOOM().createList();
        System.out.println(result);
    }

    @SuppressWarnings("unused")
    private static void pickClasses() {
        System.out.println(Arrays
                .toString((new DarkestDungeon().pickClasses(4).toArray())));
    }
}
