package lu.sfeir.java8.lambda.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by renaudchardin on 06/11/2015.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
public class Book {

    private String title;
    private String reference;
    private Author author;
    private String publishYear;

}
