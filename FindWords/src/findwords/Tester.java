package findwords;

import java.io.IOException;
import java.util.ArrayList;

public class Tester {

    private Dictionary dict;
    private Searcher search;

    public Tester() throws IOException {
        dict = new Dictionary();
        search = new Searcher();
    }

    public void testEqual(String s, String t, int n) throws IOException {
        System.out.println("equal(\"" + s + "\", \"" + t + "\", " + n + ") = " + search.equal(s, t, n));
    }

    public void testLessThan(String s, String t, int n) throws IOException {
        System.out.println("lessThan(\"" + s + "\", \"" + t + "\", " + n + ") = " + search.lessThan(s, t, n));
    }

    public void testFindPrefix(String w, int n) throws IOException {
        System.out.println("findPrefix(dict, \"" + w + "\", " + n + ") = " + search.findPrefix(dict, w, n));
    }

    public void testFindMatches(String clue) throws IOException {
        System.out.println("findMatches(dict, \"" + clue + "\") =");
        for (String w : search.findMatches(dict, clue)) {
            System.out.println(w);
        }
    }


    public static void main(String[] args) throws IOException {
        Tester tester = new Tester();

        tester.testFindMatches("bi..r.");
        tester.testFindMatches("..");
        tester.testFindMatches("..e.");
        tester.testFindMatches("..k..");
        tester.testFindMatches(".t..r.");
        tester.testFindMatches("ca..r.");
        tester.testFindMatches("..bi...");
        tester.testFindMatches("k.y");
        tester.testFindMatches("k..");
        tester.testFindMatches("..y");
        tester.testFindMatches("bik..s");
        tester.testFindMatches("bikers");
        tester.testFindMatches("act...");
        tester.testFindMatches("m..st");
        tester.testFindMatches("..f.");
        tester.testFindMatches("hike.s");
    }
}
