package lu.sfeir.java8.lambda.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import lu.sfeir.java8.lambda.domain.Author;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Authors {

    public static final String FILE_NAME = "authors.json";

    public List<Author> load() throws IOException {
        return Arrays.asList(new ObjectMapper().readValue(
                ClassLoader.getSystemClassLoader().getResource(FILE_NAME), Author[].class));
    }
}
