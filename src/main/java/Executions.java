import classes.HashMapClass;
import classes.LetterMover;
import classes.Utilities;

import java.util.HashMap;
import java.util.Scanner;

public class Executions {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            Utilities.printGreen("""
                    Welcome to HW09.
                    What are you going to do:
                    1-Check variant letters of a word
                    0-Exit
                    """,1000);
            System.out.print("      Option: ");
            String opt = sc.nextLine();
            if (opt.equals("1")) {
                letterMover();
            }

            else if(opt.equals("0")){
                break;
            }
        }
    }

    public static void letterMover(){
        LetterMover letterMover = new LetterMover();
        label:
        while(true) {
            System.out.print("\n      Word: ");
            String word = sc.nextLine();
            HashMap<String,String> variants = letterMover.getVariants(word);
            while (true) {
                System.out.println("""
                        \40          ----------------------------------------------
                        \40          1-View All variant letters
                        \40          2-Check if another entry matches variants
                        \40          3-Enter a new word
                        \40          4-Exit
                        \40          ----------------------------------------------""");
                System.out.print("           Option: ");
                String opt = sc.nextLine();
                if (opt.equals("1")) {
                    System.out.println("           ---------------------------------");
                    variants.forEach((key, value) ->{
                        System.out.print("           ");
                        Utilities.printGreen(key,250);
                    });
                    System.out.println("           ---------------------------------");
                }

                if (opt.equals("2")) {
                    System.out.print("           Word to check: ");
                    String wordToCheck = sc.nextLine();
                    if(variants.containsKey(wordToCheck)){
                        Utilities.printGreen("           Pass",800);
                    } else Utilities.printRed("           Fail",800);
                }

                if (opt.equals("3")) {
                    break;
                }

                if (opt.equals("4")) {
                    break label;
                }
            }
        }
    }
}
