package classes;

public class Utilities {
    public static void printGreen(String input,Integer waitTime){
        try {
            System.out.println( "\033[0;32m" + input + "\033[0m");
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void printRed(String input,Integer waitTime){
        try {
            System.out.println("\033[0;31m" + input + "\033[0m");
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
