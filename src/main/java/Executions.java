import classes.*;

import java.util.*;

public class Executions {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        /*
        HashMapClass<String,String> testMap = new HashMapClass<>();
        testMap.put(String.valueOf(5),String.valueOf(7));
        for(int i = 0; i < 100; i++){
            testMap.put(String.valueOf(i),String.valueOf(i));
        }
        System.out.println(testMap.size());
        boolean check = testMap.replace("1", "5","1");
        boolean checkTwo = testMap.replace("2","20","6");
        testMap.put("256","512");
        System.out.println(testMap.get("1"));
        System.out.println(testMap.get("2"));
        System.out.println(check);
        System.out.println(checkTwo);
        System.out.println(testMap.get("256"));

        HashMapClass<String,String> testMapTwo = new HashMapClass<>();
        testMapTwo.put("50","500");
        for(int i = 1000; i < 1100; i++){
            testMapTwo.put(String.valueOf(i),String.valueOf(i));
        }
        testMap.putAll(testMapTwo);
        System.out.println(testMap.get("50"));
        System.out.println(testMap.get("1050"));
        System.out.println();
*/



        label:
        while (true) {
            String one = "Welcome to HW09.";
            String two = "What are you going to do:";
            String three = "1-Variant Words(basic)";
            String four = "2-Variant Words(advanced)";
            String five = "3-The TreeSets";
            String six = "4-Ordered Pairs(basic)";
            String seven = "5-Ordered Pairs(advanced)";
            String eight = "0-Exit";
            Utilities.menuViewer(one,two,three,four,five,six,seven,eight);
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
        WordVariance wordVariance = new WordVariance();
        System.out.print("           Statement: ");
        String input = sc.nextLine();
        if(input.split(" ").length == 1){
            int time = Utilities.timeChooser(wordVariance.getVariants(input));
            System.out.println("           ---------------------------------");
            wordVariance.getVariants(input).forEach((key, value) ->{
                System.out.print("           | ");
                Utilities.printGreen(key,time);
            });
            System.out.println("           ---------------------------------");
        } else if(input.split(" ").length == 2){
            if(wordVariance.getVariants(input.split(" ")[0]).containsKey(input.split(" ")[0])){
                Utilities.printGreen("           Pass",800);
            } else Utilities.printRed("           Fail",800);
        } else Utilities.printRed("Only one word or two words split with a space are allowed here.",1000);
    }

    public static void advancedWordVariant(){
        WordVariance wordVariance = new WordVariance();
        label:
        while(true) {
            System.out.print("\n           Word: ");
            String word = sc.nextLine();
            HashMap<String,String> variants = wordVariance.getVariants(word);
            while (true) {
                String one = "1-View All variant letters";
                String two = "2-Check if another entry matches variants";
                String three = "3-Enter a new word";
                String four = "4-Exit";
                Utilities.menuViewer(one,two,three,four);
                String opt = sc.nextLine();
                if (opt.equals("1")) {
                    System.out.println("           Variants Count: " + variants.size());
                    int time = Utilities.timeChooser(variants);
                    System.out.println("           ---------------------------------");
                    variants.forEach((key, value) ->{
                        System.out.print("           | ");
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
            String one = "1-View Intersections";
            String two = "2-View Unions";
            String three = "3-View Trees";
            String four = "4-Exit";
            Utilities.menuViewer(one,two,three,four);
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
                        Utilities.printGreen("           " + firstTreeIt.next() + "          " + secondTreeIt.next(), time);
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
        System.out.print("           Original list: {");
        for(Number n: test){
            System.out.print(n + ",");
        }
        System.out.println("}");
        ArrayList<Integer> arrayList = orderedPairs.unorderedPairDeleter(test);
        System.out.print("           Manipulated list: ");
        for(Number n : arrayList){
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void advancedOrderedPairs(){
        OrderedPairs<Integer> orderedPairs = new OrderedPairs<>();
        ArrayList<Integer> inputs = new ArrayList<>();
        System.out.println("           Enter 'e' to Stop receiving number:");
        int count = 1;
        while (true) {
            System.out.print("           " + count + ": ");
            String input = sc.nextLine();
            if(!input.equals("e")){
                try{
                    inputs.add(Integer.parseInt(input));
                    count++;
                } catch (NumberFormatException e){
                    Utilities.printRed("           Only e or numbers are allowed here.",250);
                }
            } else break;
        }
        Utilities.printGreen("           Your Original list: ",500);
        System.out.print("           {");
        for(Number n: inputs){
            System.out.print(n + ",");
        }
        System.out.println("}");
        ArrayList<Integer> arrayList = orderedPairs.unorderedPairDeleter(inputs);
        Utilities.printGreen("           Pair ordered list: ",500);
        System.out.print("           {");
        for(Number n : arrayList){
            System.out.print(n + ",");
        }
        System.out.println("}");
    }

}
