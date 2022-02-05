package classes;

import java.util.HashMap;

public class LetterMover {

    /**
     * @param inputWord word to get variants of
     * @return all the variants of letter position changing in a word. using two other methods.
     */
    public HashMap<String,String> getVariants(String inputWord){
        HashMap<String ,String> output = new java.util.HashMap<>();

        for(int i = 0; i < inputWord.length();i++){
            for(int j = inputWord.length() -1; j >= 0; j--) {
                output.put(swap(inputWord, i, j),inputWord);
                output.put(swap(reverser(inputWord),j,i),inputWord);
            }
        }
        return output;
    }

    /**
     * @param str input
     * @param i first letter
     * @param j second letter
     * @return swapped letters(i and j) of a string
     */
    private String swap(String str, int i, int j) {
        char[] ch = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        StringBuilder output = new StringBuilder();
        for (char c : ch) {
            output.append(c);
        }
        return output.toString();
    }

    /**
     *
     * @param str to be reversed
     * @return reversed form of given string
     */
    public String reverser(String str){
        StringBuilder output = new StringBuilder();
        for(int i = str.length(); i > 0; i--){
            output.append(str.charAt(i - 1));
        }
        return output.toString();
    }
}
