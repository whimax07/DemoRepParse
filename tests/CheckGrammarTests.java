import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckGrammarTests {

    @Test
    void goodGrammarTest() throws ParseException {
        DemoRepParse parser = new DemoRepParse();

        assertTrue(parser.isCorrectGrammar(""));
        assertTrue(parser.isCorrectGrammar("0"));
        assertTrue(parser.isCorrectGrammar("0x0"));
        assertTrue(parser.isCorrectGrammar("0b0"));
        assertTrue(parser.isCorrectGrammar("-10"));
        assertTrue(parser.isCorrectGrammar("-0x10"));
        assertTrue(parser.isCorrectGrammar("10 + 12"));
        assertTrue(parser.isCorrectGrammar("10 * 15 - (12 * 4)"));
        assertTrue(parser.isCorrectGrammar("10 * 15 - (0x12 * 4)"));
    }


}
