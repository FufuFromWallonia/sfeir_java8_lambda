package lu.sfeir.java8.lambda.method_reference;


import lombok.Getter;

import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

@Getter
public class Player {

    private String name;

    public static void withMethodReference() {

        // tag::methodReference[]
        Function<Player, String> f1 = (player) -> player.getName();

        Function<Player, String> f2 = Player::getName;
        // end::methodReference[]

        // tag::methodReferenceStatic[]
        BinaryOperator<Integer> f3 = (int1, int2) -> int1 + int2;

        BinaryOperator<Integer> f4 = (int1, int2) -> Integer.sum(int1, int2);

        BinaryOperator<Integer> f5 = Integer::sum;
        // end::methodReferenceStatic[]


        // tag::methodReferenceStaticProperty[]
        Consumer<String> f6 = s -> System.out.println(s);

        Consumer<String> f7 = System.out::println;
        // end::methodReferenceStaticProperty[]
    }

}
