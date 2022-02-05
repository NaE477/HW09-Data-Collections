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

    public static void basicWordVariant(){
        LetterMover letterMover = new LetterMover();
        System.out.print("      Statement: ");
        String input = sc.nextLine();
        if(input.split(" ").length == 1){
            System.out.println("           ---------------------------------");
            letterMover.getVariants(input).forEach((key, value) ->{
                System.out.print("           ");
                Utilities.printGreen(key,250);
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

    public static void treeSets(){
        WordFiller wordFiller = new WordFiller();
        TreeSet<Character> firstTree = wordFiller.randomFiller(10);
        TreeSet<Character> secondTree = wordFiller.randomFiller(10);
        TreeSet<Character> intersections = wordFiller.intersection(firstTree,secondTree);
        TreeSet<Character> unions = wordFiller.unionize(firstTree,secondTree);
        label:
        while (true) {
            System.out.println("""
                    \40         1-View Intersections
                    \40         2-View Unions
                    \40         3-View Trees
                    \40         4-Exit""");
            System.out.print("          Option: ");
            String opt = sc.nextLine();
            switch (opt) {
                case "1":
                    iterateThroughOneCharSet(intersections,200);
                    break;
                case "2":
                    iterateThroughOneCharSet(unions,100);
                    break;
                case "3":
                    Iterator<Character> firstTreeIt = firstTree.iterator();
                    Iterator<Character> secondTreeIt = secondTree.iterator();
                    while (firstTreeIt.hasNext() && secondTreeIt.hasNext()) {
                        Utilities.printGreen("          " + firstTreeIt.next() + "          " + secondTreeIt.next(), 300);
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

    private static void iterateThroughOneCharSet(Set<Character> set,Integer time){
        for (Character c : set) {
            Utilities.printGreen("                " + c.toString(), time);
        }
    }

    public static void basicOrderedPairs(){
        OrderedPairs orderedPairs = new OrderedPairs();
        ArrayList<Double> test = new ArrayList<>();
        test.add(3d);
        test.add(7d);
        test.add(9d);
        test.add(2d);
        test.add(5d);
        test.add(5d);
        test.add(8d);
        test.add(5d);
        test.add(6d);
        test.add(3d);
        test.add(4d);
        test.add(7d);
        test.add(3d);
        test.add(1d);
        System.out.print("Original list: {");
        for(Double d: test){
            System.out.print(d + ",");
        }
        System.out.println("}");
        ArrayList<Double> arrayList = orderedPairs.unorderedPairDeleter(test);
        System.out.print("Manipulated list: ");
        for(Double d : arrayList){
            System.out.print(d + " ");
        }
    }

    public static void advancedOrderedPairs(){
        OrderedPairs orderedPairs = new OrderedPairs();
        ArrayList<Double> inputs = new ArrayList<>();
        System.out.println("Enter 'e' to Stop receiving number:");
        while (true) {
            String input = sc.nextLine();
            if(!input.equals("e")){
                try{
                    inputs.add(Double.parseDouble(input));
                } catch (NumberFormatException e){
                    System.out.println("Only e or numbers are allowed here.");
                }
            } else break;
        }
        System.out.print("Your Original list: {");
        for(Double d: inputs){
            System.out.print(d + ",");
        }
        System.out.println("}");
        ArrayList<Double> arrayList = orderedPairs.unorderedPairDeleter(inputs);
        System.out.print("Manipulated list: ");
        for(Double d : arrayList){
            System.out.print(d + " ");
        }
    }

}
