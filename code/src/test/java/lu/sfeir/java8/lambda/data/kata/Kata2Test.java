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

        OptionalInt max = getBooks().stream()
                .filter(book -> book.getAuthor().getName().equalsIgnoreCase("J. K. Rowling"))
                .mapToInt(book -> Integer.valueOf(book.getPublishYear()))
                .max();

        MatcherAssert.assertThat(max.getAsInt(), CoreMatchers.equalTo(2007));
    }

    /**
     * Get the author who published the most book
     *
     * @throws IOException
     */
    @Test
    public void author_who_published_the_most_book() throws IOException {

        Map.Entry<Author, Long> authorWhoPublishedTheMostBooks = getBooks().stream()
                .collect(Collectors.groupingBy(o -> o.getAuthor(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .get();

        System.out.println("The author " + authorWhoPublishedTheMostBooks.getKey().getName()
                + " published " + authorWhoPublishedTheMostBooks.getValue() + " books");
    }

    private List<Book> getBooks() throws IOException {
        return new Books().load();
    }
}
