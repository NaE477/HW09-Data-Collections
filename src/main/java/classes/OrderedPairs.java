package classes;

import java.util.ArrayList;

public class OrderedPairs {
    public ArrayList<Double> unorderedPairDeleter(ArrayList<Double> input) {
        if (input.size() != 0) {
            if (input.size() % 2 == 0) {
                for (int i = 0; i < input.size(); i += 2) {
                    if (input.get(i) > input.get(i + 1)) {
                        input.remove(i);
                        input.remove(i);
                        i -= 2;
                    }
                }
            } else {
                input.remove(input.size() - 1);
                for (int i = 0; i < input.size(); i += 2) {
                    if (input.get(i) > input.get(i + 1)) {
                        input.remove(i);
                        input.remove(i);
                        i -= 2;
                    }
                }
            }
        } else return input;
        return input;
    }
}
