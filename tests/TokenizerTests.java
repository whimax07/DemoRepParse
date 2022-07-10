import org.junit.jupiter.api.Test;
import tokens.*;
import tokens.Number;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenizerTests {

    @Test
    void checkTokenizer() {
        assertEquals(Tokenizer.tokenizer(""),
                makeList(
                        // Empty.
                ));

        assertEquals(Tokenizer.tokenizer("0"),
                makeList(
                        new Number("0")
                ));

        assertEquals(Tokenizer.tokenizer("1110"),
                makeList(
                        new Number("1110")
                ));

        assertEquals(Tokenizer.tokenizer("10 * 20 + 30"),
                makeList(
                        new Number("10"),
                        Binary.MULTIPLY,
                        new Number("20"),
                        Binary.ADD,
                        new Number("30")
                ));

        assertEquals(Tokenizer.tokenizer("10 * -20 + 30"),
                makeList(
                        new Number("10"),
                        Binary.MULTIPLY,
                        Unary.NEGATE,
                        new Number("20"),
                        Binary.ADD,
                        new Number("30")
                ));

        assertEquals(Tokenizer.tokenizer("0x10 * -20 + 0b1110"),
                makeList(
                        new Number("0x10"),
                        Binary.MULTIPLY,
                        Unary.NEGATE,
                        new Number("20"),
                        Binary.ADD,
                        new Number("0b1110")
                ));

        assertEquals(Tokenizer.tokenizer("0x10 / -20 - 0b1110"),
                makeList(
                        new Number("0x10"),
                        Binary.DIVIDE,
                        Unary.NEGATE,
                        new Number("20"),
                        Binary.SUBTRACT,
                        new Number("0b1110")
                ));
    }

    static ArrayList<Token> makeList(Token... tokens) {
        return new ArrayList<>(Arrays.asList(tokens));
    }

}
