package classes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;

public class OrderedPairs<T extends Number & Comparable<T>> implements Comparator<Number> {

    /**
     * arranges input list from pair ordering view. primarily using deleter method.
     * @param inputList input list
     * @return Ordered list in case of pair ordering
     */
    public ArrayList<T> arrangePairs(ArrayList<T> inputList) {
        ArrayList<T> newList = new ArrayList<>(inputList);
        if (newList.size() != 0) {
            if (newList.size() % 2 != 0) {
                newList.remove(newList.size() - 1); //remove last item of an odd list
            }
            return deleter(newList);
        } else throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * Deletes unordered pairs of the input list
     * @param inputList input list
     * @return List with deleted unordered pairs
     */
    private ArrayList<T> deleter(ArrayList<T> inputList){
        for (int i = 0; i < inputList.size(); i += 2) {
            if (compare(inputList.get(i) , inputList.get(i + 1)) > 0) {
                inputList.remove(i);
                inputList.remove(i);
                i -= 2;
            }
        }
        return inputList;
    }

    /**
     * Compares two numbers in the range of BigDecimal
     * @return 1 if a is bigger than b,-1 if b is bigger than a ,and 0 if two values are equal
     */
    @Override
    public int compare(Number a, Number b) {
        return new BigDecimal(a.toString()).compareTo(new BigDecimal(b.toString()));
    }
}
