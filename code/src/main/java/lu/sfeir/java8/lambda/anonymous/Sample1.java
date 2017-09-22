package lu.sfeir.java8.lambda.anonymous;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Yannick on 17-09-17.
 */
public class Sample1 {

    public void comparatorUsingAnonymousClasses()

    {
        // tag::withAnonymous[]
        Comparator<String> comparator = new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };

        String[] strings = {"Alain", "Benjamin"};
        Arrays.sort(strings, comparator);
        // end::withAnonymous[]
    }

    public void comparatorUsingLambda() {

        // tag::withLambda[]
        Comparator<String> comparator =
                (String s1, String s2)
                        -> Integer.compare(s1.length(), s2.length());
        // end::withLambda[]
        String[] strings = {"Alain", "Benjamin"};
        Arrays.sort(strings, comparator);
    }

    public void comparatorWithoutType() {

        // tag::withLambdaWithType[]
        Comparator<String> comparator =
                (s1, s2)
                        -> Integer.compare(s1.length(), s2.length());
        // end::withLambdaWithType[]
        String[] strings = {"Alain", "Benjamin"};
        Arrays.sort(strings, comparator);
    }
}
