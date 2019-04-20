package testLinter;

import org.junit.Test;

import java.io.IOException;

import static javaFundaments.linter.linter.linter;
import static junit.framework.TestCase.assertEquals;

public class testLinter {
    @Test
    public void noErrors() throws IOException {
        String expected = "";
        assertEquals(expected, linter("src/main/resources/noErrors.js"));

    }

    @Test
    public void oneErrors() throws IOException {
        String expected = "Line 1: Error missing semicolon\n";

        assertEquals(expected, linter("src/main/resources/oneError.js"));

    }

    @Test
    public void fewErrors() throws IOException {
        String expected = "Line 1: Error missing semicolon\n" +
                "Line 2: Error missing semicolon\n" +
                "Line 4: Error missing semicolon\n";
        assertEquals(expected, linter("src/main/resources/fewErrors.js"));
    }

    @Test
    public void manyErrors() throws IOException {
        String expected = "Line 1: Error missing semicolon\n" +
                "Line 2: Error missing semicolon\n" +
                "Line 4: Error missing semicolon\n" +
                "Line 9: Error missing semicolon\n" +
                "Line 13: Error missing semicolon\n";
        assertEquals(expected, linter("src/main/resources/manyErrors.js"));

    }

    @Test
    public void emptyFile() throws IOException {
        String expected = "";
        String actual = linter("src/main/resources/empty.js");

        assertEquals(expected, actual);
    }

}
