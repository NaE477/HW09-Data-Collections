package classes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;

public class OrderedPairs<T extends Number> implements Comparator<Number> {

    public ArrayList<T> unorderedPairDeleter(ArrayList<T> input) {
        if (input.size() != 0) {
            if (input.size() % 2 == 0) {
                for (int i = 0; i < input.size(); i += 2) {
                    if (compare(input.get(i), input.get(i + 1)) > 0) {
                        input.remove(i);
                        input.remove(i);
                        i -= 2;
                    }
                }
            } else {
                input.remove(input.size() - 1);
                for (int i = 0; i < input.size(); i += 2) {
                    if (compare(input.get(i) , input.get(i + 1)) > 0) {
                        input.remove(i);
                        input.remove(i);
                        i -= 2;
                    }
                }
            }
        } else return input;
        return input;
    }

    @Override
    public int compare(Number a, Number b) {
        return new BigDecimal(a.toString()).compareTo(new BigDecimal(b.toString()));
    }
}
