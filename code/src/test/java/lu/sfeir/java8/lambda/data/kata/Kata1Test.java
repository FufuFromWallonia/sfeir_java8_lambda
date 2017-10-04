package lu.sfeir.java8.lambda.data.kata;

import org.junit.Test;

import java.util.Objects;

import static lu.sfeir.java8.lambda.data.kata.Verify.*;

public class Kata1Test {

    /**
     * The predicate should match only with Victor Hugo
     */
    @Test
    public void should_match_victor_hugo() {

        verifyVictorHugo(author -> "Victor Hugo".equalsIgnoreCase(author.getName()));
    }

    /**
     * The predicate should match only the authors whose reference property is not null
     */
    @Test
    public void should_match_authors_having_reference() {

        verifyAuthorsHavingReference(author -> Objects.nonNull(author.getReference()));
    }

    /**
     * The lambda receives a collection of authors in parameter and returns the first of the list
     */
    @Test
    public void should_return_the_first_author_of_the_authors_given_in_parameter() {

        verifyFirstAuthorIsReturnedFromTheGivenList(authors -> authors.get(0));
    }

    /**
     * The first lambda should return a second lambda filtering on the name given as parameter to the first lambda.
     * The first lambda takes a name as parameter and returns a new lambda
     * The second lambda takes an author as parameter and returns a boolean
     */
    @Test
    public void should_pass_a_function_that_return_a_lambda_which_filter_the_authors_on_a_given_name() {

        verifyFunctionReturningAFunction(name -> author -> name.equalsIgnoreCase(author.getName()));
    }
}
