package lu.sfeir.java8.lambda.anonymous;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Executors;

/**
 * Created by Yannick on 17-09-17.
 */
public class Sample2 {

    public void comparatorUsingAnonymousClasses()

    {
        Runnable r = new Runnable() {
            public void run() {
                int i = 0;
                while (i++ < 10) {
                    System.out.println("It works!");
                }
            }
        };

        Executors.newSingleThreadExecutor().execute(r);
    }

    public void comparatorUsingLambda() {

        Runnable r = () -> {
            int i = 0;
            while (i++ < 10) {
                System.out.println("It works!");
            }
        };

        Executors.newSingleThreadExecutor().execute(r);
    }
}
