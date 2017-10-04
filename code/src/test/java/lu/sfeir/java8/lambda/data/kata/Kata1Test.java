package lu.sfeir.java8.lambda.data.kata;

import org.junit.Test;

import static lu.sfeir.java8.lambda.data.kata.Verify.*;

public class Kata1Test {

    /**
     * The predicate should match only with Victor Hugo
     */
    @Test
    public void should_match_victor_hugo() {

        verifyVictorHugo(null);
    }

    /**
     * The predicate should match only the authors whose reference property is not null
     */
    @Test
    public void should_match_authors_having_reference() {

        verifyAuthorsHavingReference(null);
    }

    /**
     * The lambda receives a collection of authors in parameter and returns the first of the list
     */
    @Test
    public void should_return_the_first_author_of_the_authors_given_in_parameter() {

        verifyFirstAuthorIsReturnedFromTheGivenList(null);
    }

    /**
     * The first lambda should return a second lambda filtering on the name given as parameter to the first lambda.
     * The first lambda takes a name as parameter and returns a new lambda
     * The second lambda takes an author as parameter and returns a boolean
     */
    @Test
    public void should_pass_a_function_that_return_a_lambda_which_filter_the_authors_on_a_given_name() {

        verifyFunctionReturningAFunction(null);
    }
}
