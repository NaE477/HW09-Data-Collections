package classes;

import lombok.Getter;

import java.util.TreeSet;

@Getter
public class WordFiller {

    /**
     * Fills the tree with input size,custom lower bound and custom upper bound.
     * Returns null if character range is lower than size
     * @param size size of returning TreeSet
     * @param lowerBound Lower bound of characters to fill TreeSet with
     * @param upperBound Upper bound of characters to fill TreeSet with
     * @return TreeSet containing random characters of custom size,custom lower and upper bound
     */
    public TreeSet<Character> randomFiller(Integer size,Character lowerBound,Character upperBound){
        TreeSet<Character> output = new TreeSet<>();
        if( ((int) upperBound - lowerBound) >= size) { //characters range should not be smaller than the input size
            while (output.size() < size) {
                output.add(Utilities.rangedBaseRandomizer(lowerBound, upperBound));
            }
            return output;
        } else return null;
    }

    /**
     * Fills a TreeSet with random characters in a default range of characters: a - z
     * @param size size of returning TreeSet
     * @return TreeSet containing random characters
     */
    public TreeSet<Character> randomFiller(Integer size){
        return randomFiller(size,'a','z');
    }

    /**
     * Uses addAll method from TreeSet class to unionize input sets
     * @param inputs varargs
     * @return unionized tree of inputs
     */
    @SafeVarargs
    public final TreeSet<Character> unionize(TreeSet<Character>... inputs){
        TreeSet<Character> firstTreeCopy = new TreeSet<>(inputs[0]);
        for(TreeSet<Character> set: inputs) {
            firstTreeCopy.addAll(set);
        }
        return firstTreeCopy;
    }

    /**
     * Uses retainAll method from TreeSet class to find intersections of input sets
     * @param inputs TreeSets with Character type
     * @return TreeSet containing intersections of input TreeSets
     */
    @SafeVarargs
    public final TreeSet<Character> intersection(TreeSet<Character>... inputs){
        TreeSet<Character> firstTreeCopy = new TreeSet<>(inputs[0]);
        for(TreeSet<Character> sets: inputs){
            firstTreeCopy.retainAll(sets);
        }
        return firstTreeCopy;
    }
}
