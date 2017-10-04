package lu.sfeir.java8.lambda.data.kata;

import lu.sfeir.java8.lambda.data.Books;
import lu.sfeir.java8.lambda.domain.Author;
import lu.sfeir.java8.lambda.domain.Book;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Kata2Test {

    /**
     * Get the year of the last publication of J. K. Rowling
     *
     * @throws IOException
     */
    @Test
    public void year_of_the_last_publication_of_jk_rowling() throws IOException {

        int max = 0;
        MatcherAssert.assertThat(max, CoreMatchers.equalTo(2007));
    }

    /**
     * Get the author who published the most book
     *
     * @throws IOException
     */
    @Test
    public void author_who_published_the_most_book() throws IOException {

        String name = null;
        Long nbOfBooks = null;
        System.out.println("The author " + name
                + " published " + nbOfBooks + " books");
    }

    private List<Book> getBooks() throws IOException {
        return new Books().load();
    }
}
