package lu.sfeir.java8.lambda.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import lu.sfeir.java8.lambda.domain.Book;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Books {

    public static final String FILE_NAME = "books.json";

    public List<Book> load() throws IOException {
        return Arrays.asList(new ObjectMapper().readValue(
                ClassLoader.getSystemClassLoader().getResource(FILE_NAME), Book[].class));
    }
}
