package classes;

import java.util.HashMap;

public class LetterMover {

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

    public String reverser(String str){
        StringBuilder output = new StringBuilder();
        for(int i = str.length(); i > 0; i--){
            output.append(str.charAt(i - 1));
        }
        return output.toString();
    }
}
