package lu.sfeir.java8.lambda.anonymous;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Yannick on 17-09-17.
 */
public class Sample1 {

    public void comparatorUsingAnonymousClasses()

    {
        Comparator<String> comparator = new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };

        String[] strings = {"Alain", "Benjamin"};
        Arrays.sort(strings, comparator);
    }

    public void comparatorUsingLambda() {

        Comparator<String> comparator = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());

        String[] strings = {"Alain", "Benjamin"};
        Arrays.sort(strings, comparator);
    }
}
