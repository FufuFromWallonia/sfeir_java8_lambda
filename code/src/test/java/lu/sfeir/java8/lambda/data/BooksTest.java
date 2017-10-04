package lu.sfeir.java8.lambda.data;


import lu.sfeir.java8.lambda.domain.Book;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class BooksTest {

    @Test
    public void should_load_the_authors() throws IOException {

        List<Book> authors = new Books().load();
        assertThat(authors, CoreMatchers.notNullValue());
        assertThat(authors.isEmpty(), CoreMatchers.equalTo(false));
    }
}
