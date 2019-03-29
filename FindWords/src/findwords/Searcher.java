package findwords;

import java.util.ArrayList;
import java.util.regex.*;
/**
 * Your implementation of the coursework.
 * This is the only source file you should modify, and the only one you
 * should submit.  The signatures of these methods should not be modified.
 */
public class Searcher {

    /**
     * Compare the front part of two character arrays for equality.
     * @param s the first character array
     * @param t the second character array
     * @param n number of characters to compare
     * @return true if s and t are equal up to the first n characters
     */
    public boolean equal(String s, String t, int n) {
        n = checkBoundaries(s, t, n);
        // invariant: 0<i<n  and s.charAt[i] = t.charAt[i]
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compare the front part of two character arrays.
     * @param s the first character array
     * @param t the second character array
     * @param n number of characters to compare
     * @return true if s is less than t in the first n characters
     */

    public boolean lessThan(String s, String t, int n) {
        n = checkBoundaries(s, t, n);
        // invariant: 0<i<(n-1) and s.charAt[i] = t.charAt[i]
        for (int i = 0;  i < n; i++){
            if(s.charAt(i) != t.charAt(i)){
                return(s.charAt(i) < t.charAt(i));
            }
            else if(i == s.length()-1){
                return(s.charAt(i) == t.charAt(i));
            }
        }
        return !equal(s, t, n);
    }

    /**
     * Find the first position of a prefix in a dictionary.
     * @param d an ordered dictionary of words
     * @param w a prefix to search for
     * @param n number of characters to compare
     * @return the least index such that all earlier entries in the dictionary
     * are smaller than e when comparing the first n characters.
     */
    public int findPrefix(Dictionary d, String w, int n) {
        int lower = 0;
        int upper = d.size()-1;
        int middle;
        // invariant: lower is smaller or equal to upper
        while(lower <= upper) {
            middle = (lower+upper)/2;
            if(lessThan((d.getWord(middle)), w, n)) {
                lower = middle + 1;
            }
            else {
                upper = middle -1;
            }
        }
        return lower;
    }

    /**
     * Search a dictionary for words matching a clue.
     * @param d an ordered dictionary of words
     * @param clue a word to search for, with . standing for any character
     * @return a list of all the words in the dictionary that match the clue
     */
    public ArrayList<String> findMatches(Dictionary d, String clue) {
        ArrayList<String> matches = new ArrayList<>();
        int n = clue.length();
        int initialPos;
        char charChecker;
        int charPivot;
        boolean firstDot = true;
        boolean noDots = true;
        // invariant: 0<i<clue.length and clue.charAt[i] != '.'
        for(int i = 0; i < clue.length(); i++){
            if (clue.charAt(i) == '.' && clue.charAt(0) != '.'){
                n = i;
                firstDot = false;
                noDots = false;
                break;
            }
            else if(clue.charAt(0) == '.'){
                noDots = false;
                break;
            }
        }
        if(noDots){
            initialPos = findPrefix(d, clue, n) -1;
            firstDot = false;
        }
        else{
            initialPos = findPrefix(d, clue, n);
        }
        charChecker = clue.charAt(n-1);
        charPivot = n-1;
        // invariant: initialPos<i<d.size and charChecker = d.getWord[i].charAt[charChecker]
        for(int i = initialPos; i < d.size(); i++) {
            if (d.getWord(i).length() == clue.length()) {
                if (charChecker == d.getWord(i).charAt(charPivot)) {
                    regexChecker(clue, d.getWord(i), matches);
                } else if (firstDot) {
                    regexChecker(clue, d.getWord(i), matches);
                }
            }
            if(noDots){
                break;
            }
            else if (!firstDot) {
                if (charChecker != d.getWord(i).charAt(charPivot)) {
                    break;
                }
            }
        }
        return matches;
    }


    public int checkBoundaries(String s, String t, int n){
        if(s.length() < n || t.length() < n){
            if(s.length() > t.length()){
                n = t.length();
            }
            else{
                n = s.length();
            }
        }
        return n;
    }
    public static void regexChecker(String theRegex, String dictWord, ArrayList<String> matches){
        Pattern checkRegex = Pattern.compile(theRegex);
        Matcher regexMarcher = checkRegex.matcher(dictWord);
        if(regexMarcher.find()){
            matches.add(regexMarcher.group());
        }
    }
}
