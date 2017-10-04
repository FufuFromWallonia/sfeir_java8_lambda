package lu.sfeir.java8.lambda.data.kata;

import lu.sfeir.java8.lambda.data.Authors;
import lu.sfeir.java8.lambda.domain.Author;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class Verify {

    static void verifyVictorHugo(Predicate<Author> victorHugoPredicate) {

        List<Author> matchingAuthors = getAuthors().stream().filter(victorHugoPredicate)
                .collect(Collectors.toList());
        assertThat("No user named Victor Hugo was found", matchingAuthors.isEmpty(), equalTo(false));
        assertThat("Multiple users were found, there is only one Victor Hugo on Earth", matchingAuthors.size(), equalTo(1));
        String name = matchingAuthors.get(0).getName();
        assertThat("I don't believe Victor Hugo's name is " + name, name, equalTo("Victor Hugo"));
    }

    static void verifyAuthorsHavingReference(Predicate<Author> authorPredicate) {

        List<Author> matchingAuthors = getAuthors().stream().filter(authorPredicate)
                .collect(Collectors.toList());
        assertThat("No user was found but I ensure you that there are some to find!", matchingAuthors.isEmpty(), equalTo(false));
        assertThat("In fact they are only 2", matchingAuthors.size(), equalTo(2));
        assertThat("First author is supposed to be J. R. R. Tolkien", matchingAuthors.get(0).getName(), equalTo("J. R. R. Tolkien"));
        assertThat("First author is supposed to be George R. R. Martin", matchingAuthors.get(1).getName(), equalTo("George R. R. Martin"));
    }

    static void verifyFirstAuthorIsReturnedFromTheGivenList(Function<List<Author>, Author> mapper) {

        List<Author> authors = getAuthors();
        List<Author> sortedAuthors = authors.stream().sorted(Comparator.comparing(Author::getName))
                .collect(Collectors.toList());
        Author first = mapper.apply(sortedAuthors);
        assertThat(first, equalTo(sortedAuthors.get(0)));
    }

    static void verifyFunctionReturningAFunction(Function<String, Predicate<Author>> filterOnNamePredicate) {

        List<Author> authors = getAuthors();
        Optional<Author> victorHugo = authors.stream().filter(filterOnNamePredicate.apply("Victor Hugo")).findFirst();
        victorHugo.ifPresent(author -> assertThat(author.getName(), equalTo("Victor Hugo")));
        victorHugo.orElseThrow(() -> new RuntimeException("It does not seems to work, no user was found"));

        Optional<Author> reneLevy = authors.stream().filter(filterOnNamePredicate.apply("René Levy")).findFirst();
        reneLevy.ifPresent(author -> assertThat(author.getName(), equalTo("René Levy")));
        reneLevy.orElseThrow(() -> new RuntimeException("It does not seems to work, no user was found"));
    }

    private static List<Author> getAuthors() {
        try {
            return new Authors().load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
