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

        /*tester.testEqual("binder", "binding", 4);
        tester.testEqual("binder", "binding", 5);
        tester.testEqual("bind", "bind", 5);
        tester.testEqual("bind", "nigh", 6);*/

        /*tester.testLessThan("binary", "bind", 4);
        tester.testLessThan("binder", "binding", 4);
        tester.testLessThan("binding", "binder", 4);
        tester.testLessThan("bin", "binary", 4);
        tester.testLessThan("bit", "binary", 4);
        tester.testLessThan("binary", "bin", 4);
        tester.testLessThan("binary", "bit", 4);
        tester.testLessThan("niggle", "niggardly", 6);
        tester.testLessThan("niggardly", "niggle", 12);
        tester.testLessThan("bit", "broads", 4);
        tester.testLessThan("broads", "bit", 8);*/






        /*tester.testFindPrefix("bi", 2);
        tester.testFindPrefix("bi..r.", 2);
        tester.testFindPrefix("ac", 2);
        tester.testFindPrefix("ab.....s", 2);
        tester.testFindPrefix("ab.....s", 8);
        tester.testFindPrefix("abalones", 8);
        tester.testFindPrefix("abaft", 5);
        tester.testFindPrefix("a...t", 1);
        tester.testFindPrefix("zygotes", 7);
        tester.testFindPrefix("accidentally", 12);*/
        //tester.testFindPrefix("ac.........y", 12);
        //tester.testFindPrefix("..na..", 2);


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
