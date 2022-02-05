package classes;

import lombok.Getter;

import java.util.Random;
import java.util.TreeSet;

@Getter
public class WordFiller {
    Random random = new Random();

    public TreeSet<Character> randomFiller(Integer size){
        TreeSet<Character> output = new TreeSet<>();
        while (output.size() < size) {
                output.add(rangedBaseRandomizer('a', 'z'));
        }
        return output;
    }

    public TreeSet<Character> unionize(TreeSet<Character> firstTree, TreeSet<Character> secondTree){
        TreeSet<Character> firstTreeCopy = new TreeSet<>();
        firstTreeCopy.addAll(firstTree);
        firstTreeCopy.addAll(secondTree);
        return firstTreeCopy;
    }
    public TreeSet<Character> intersection(TreeSet<Character> firstTree, TreeSet<Character> secondTree){
        TreeSet<Character> firstTreeCopy = new TreeSet<>();
        firstTreeCopy.addAll(firstTree);
        firstTreeCopy.retainAll(secondTree);
        return firstTreeCopy;
    }

    private Character rangedBaseRandomizer(Character lowerBound,Character upperBound){
        return (char) ((int) (Math.random() * (upperBound - lowerBound) + lowerBound));
    }
}
