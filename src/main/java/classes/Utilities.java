package classes;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Utilities {
    public static void printGreen(String input,Integer pauseTime){
        try {
            System.out.println( "\033[0;32m" + input + "\033[0m");
            Thread.sleep(pauseTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printRed(String input,Integer pauseTime){
        try {
            System.out.println("\033[0;31m" + input + "\033[0m");
            Thread.sleep(pauseTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void iterateThroughCharSet(Set<Character> set, Integer time){
        for (Character c : set) {
            System.out.print("\033[0;32m" + "          " + c.toString() + "  " + "\033[0m");
        }
        System.out.println();
    }
    public static Integer timeChooser(Collection<?> collection){
        if (collection.size() > 10) {
            return  100;
        } else return  250;
    }
    public static Integer timeChooser(Map<?,?> collection){
        if (collection.size() > 10) {
            return  20;
        } else return  250;
    }
}
