package lu.sfeir.java8.lambda.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class FilterApi {

    // tag::player[]
    @AllArgsConstructor
    @Getter
    @Setter
    public static class Player {

        private String name;
        private int xp;
        private boolean gameFinished;

        public Player(String name) {
            this.name = name;
        }
    }
    // end::player[]

    /**
     * Create a simple lambda
     */
    static public class A {

        // tag::a-api[]
        public interface Filter {

            boolean test(Player player);
        }
        // end::a-api[]

        public void doSomething() {
            // tag::a-code[]
            Filter moreThan20XP = (player) -> player.getXp() > 20;

            System.out.println(moreThan20XP.
                    test(new Player("Jimmy", 10, false))); // false

            System.out.println(moreThan20XP.
                    test(new Player("Toto", 30, false))); // true
            // end::a-code[]
        }
    }

    /**
     * Add a default method
     */
    static public class B {

        // tag::b-api[]
        public interface Filter {

            boolean test(Player player);

            default Filter and(Filter filter) {

                return player -> this.test(player) && filter.test(player);
            }
        }
        // end::b-api[]

        public void doSomething() {
            // tag::b-code[]
            Filter gameFinished = (player) -> player.isGameFinished();
            Filter moreThan20XP = (player) -> player.getXp() > 20;

            Filter rockStar = gameFinished.and(moreThan20XP);

            System.out.println(rockStar.
                    test(new Player("Noob", 10, false))); // false

            System.out.println(rockStar.
                    test(new Player("Florian", 15, true))); // false

            System.out.println(rockStar.
                    test(new Player("Jimmy", 25, true))); // true
            // end::b-code[]
        }
    }

    /**
     * Make the API generic
     */
    static public class C {

        // tag::c-api[]
        public interface Filter<T> {

            boolean test(T subject);

            default Filter<T> and(Filter<T> filter) {

                return subject -> this.test(subject) && filter.test(subject);
            }
        }
        // end::c-api[]

        // tag::c-specific-api[]
        public interface PlayerFilter {

            Filter<Player> GAME_FINISHED = (player) -> player.isGameFinished();

            Filter<Player> MORE_THAN_20_XP = (player) -> player.getXp() > 20;

            Filter<Player> ROCK_STAR = GAME_FINISHED.and(MORE_THAN_20_XP);

            static Filter<Player> hasMoreXPThan(int xp) {

                return (player -> player.getXp() > xp);
            }
        }
        // end::c-specific-api[]

        public void doSomething() {
            // tag::c-code[]
            System.out.println(PlayerFilter.ROCK_STAR.
                    test(new Player("Noob", 10, false))); // false

            System.out.println(PlayerFilter.ROCK_STAR.
                    test(new Player("Warrior", 15, true))); // false

            System.out.println(PlayerFilter.ROCK_STAR.
                    test(new Player("Jimmy", 25, true))); // true

            System.out.println(PlayerFilter.hasMoreXPThan(50).
                    test(new Player("Bastien", 25, true))); // false

            System.out.println(PlayerFilter.hasMoreXPThan(50).
                    test(new Player("Karl", 51, true))); // true
            // end::c-code[]
        }
    }

    public static void main(String... args) {

        System.out.println("------");
        System.out.println("A");
        new A().doSomething();

        System.out.println("------");
        System.out.println("B");
        new B().doSomething();

        System.out.println("------");
        System.out.println("C");
        new C().doSomething();
    }
}
