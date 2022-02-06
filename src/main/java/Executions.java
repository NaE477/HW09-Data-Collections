import classes.LetterMover;
import classes.OrderedPairs;
import classes.Utilities;
import classes.WordFiller;

import java.util.*;

public class Executions {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        label:
        while (true) {
            Utilities.printGreen("""
                    
                    Welcome to HW09.
                    What are you going to do:
                    1-Variant Words(basic)
                    2-Variant Words(advanced)
                    3-The TreeSets
                    4-Ordered Pairs(basic)
                    5-Ordered Pairs(advanced)
                    0-Exit
                    """,1000);
            System.out.print("      Option: ");
            String opt = sc.nextLine();
            switch (opt) {
                case "1":
                    basicWordVariant();
                    break;
                case "2":
                    advancedWordVariant();
                    break;
                case "3":
                    treeSets();
                    break;
                case "4":
                    basicOrderedPairs();
                    break;
                case "5":
                    advancedOrderedPairs();
                    break;
                case "0":
                    break label;
                default:
                    Utilities.printRed("Wrong Option", 100);
            }
        }
    }

    //1-
    public static void basicWordVariant(){
        LetterMover letterMover = new LetterMover();
        System.out.print("      Statement: ");
        String input = sc.nextLine();
        if(input.split(" ").length == 1){
            int time = Utilities.timeChooser(letterMover.getVariants(input));
            System.out.println("           ---------------------------------");
            letterMover.getVariants(input).forEach((key, value) ->{
                System.out.print("           ");
                Utilities.printGreen(key,time);
            });
            System.out.println("           ---------------------------------");
        } else if(input.split(" ").length == 2){
            if(letterMover.getVariants(input.split(" ")[0]).containsKey(input.split(" ")[0])){
                Utilities.printGreen("           Pass",800);
            } else Utilities.printRed("           Fail",800);
        } else Utilities.printRed("Only one word or two words split with a space are allowed here.",1000);
    }

    public static void advancedWordVariant(){
        LetterMover letterMover = new LetterMover();
        label:
        while(true) {
            System.out.print("\n           Word: ");
            String word = sc.nextLine();
            HashMap<String,String> variants = letterMover.getVariants(word);
            while (true) {
                Utilities.printGreen("""
                        \40          ----------------------------------------------
                        \40          1-View All variant letters
                        \40          2-Check if another entry matches variants
                        \40          3-Enter a new word
                        \40          4-Exit
                        \40          ----------------------------------------------""",500);
                System.out.print("           Option: ");
                String opt = sc.nextLine();
                if (opt.equals("1")) {
                    int time = Utilities.timeChooser(variants);
                    System.out.println("           ---------------------------------");
                    variants.forEach((key, value) ->{
                        System.out.print("           ");
                        Utilities.printGreen(key,time);
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

    //2-
    public static void treeSets(){
        WordFiller wordFiller = new WordFiller();
        TreeSet<Character> firstTree = wordFiller.randomFiller(10);
        TreeSet<Character> secondTree = wordFiller.randomFiller(10);
        TreeSet<Character> intersections = wordFiller.intersection(firstTree,secondTree);
        TreeSet<Character> unions = wordFiller.unionize(firstTree,secondTree);
        label:
        while (true) {
            Utilities.printGreen("""
                    \40         1-View Intersections
                    \40         2-View Unions
                    \40         3-View Trees
                    \40         4-Exit""",500);
            System.out.print("          Option: ");
            String opt = sc.nextLine();
            switch (opt) {
                case "1":
                    Utilities.iterateThroughCharSet(intersections,200);
                    break;
                case "2":
                    Utilities.iterateThroughCharSet(unions,100);
                    break;
                case "3":
                    int time = Utilities.timeChooser(firstTree);
                    Iterator<Character> firstTreeIt = firstTree.iterator();
                    Iterator<Character> secondTreeIt = secondTree.iterator();
                    while (firstTreeIt.hasNext() && secondTreeIt.hasNext()) {
                        Utilities.printGreen("          " + firstTreeIt.next() + "          " + secondTreeIt.next(), time);
                    }
                    break;
                case "4":
                    break label;
                default:
                    Utilities.printRed("Wrong Input!", 500);
                    break;
            }
        }
    }

    //3-
    public static void basicOrderedPairs(){
        OrderedPairs<Integer> orderedPairs = new OrderedPairs<>();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(3);
        test.add(7);
        test.add(9);
        test.add(2);
        test.add(5);
        test.add(5);
        test.add(8);
        test.add(5);
        test.add(6);
        test.add(3);
        test.add(4);
        test.add(7);
        test.add(3);
        test.add(1);
        System.out.print("Original list: {");
        for(Number n: test){
            System.out.print(n + ",");
        }
        System.out.println("}");
        ArrayList<Integer> arrayList = orderedPairs.unorderedPairDeleter(test);
        System.out.print("Manipulated list: ");
        for(Number n : arrayList){
            System.out.print(n + " ");
        }
    }

    public static void advancedOrderedPairs(){
        OrderedPairs<Integer> orderedPairs = new OrderedPairs<>();
        ArrayList<Integer> inputs = new ArrayList<>();
        System.out.println("      Enter 'e' to Stop receiving number:");
        int count = 1;
        while (true) {
            System.out.print("      " + count + ": ");
            String input = sc.nextLine();
            if(!input.equals("e")){
                try{
                    inputs.add(Integer.parseInt(input));
                    count++;
                } catch (NumberFormatException e){
                    System.out.println("Only e or numbers are allowed here.");
                }
            } else break;
        }
        Utilities.printGreen("      Your Original list: ",500);
        System.out.print("      {");
        for(Number n: inputs){
            System.out.print(n + ",");
        }
        System.out.println("}");
        ArrayList<Integer> arrayList = orderedPairs.unorderedPairDeleter(inputs);
        Utilities.printGreen("      Manipulated list: ",500);
        System.out.print("      {");
        for(Number n : arrayList){
            System.out.print(n + ",");
        }
        System.out.println("}");
    }

}
