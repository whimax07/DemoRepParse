import com.sun.jdi.Value;
import data.Binary;
import data.Brackets;
import data.Number;
import data.Primitive;
import data.Unary;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
    E --> P {B P}
    P --> v | "(" E ")" | U P
    B --> "+" | "-" | "*" | "/"
    U --> "-"
 */
public class Tokenizer {

    private final String inputString;

    private final char[] input;

    private final ArrayList<Primitive> tokens = new ArrayList<>();

    private int fast = 0;

    private int slow = 0;



    public static ArrayList<Primitive> tokenizer(String input) {
        Tokenizer tokenizer = new Tokenizer(input);
        return tokenizer.tokens;
    }



    private Tokenizer(String input) {
        this.inputString = input;
        this.input = input.toCharArray();
        begin();
    }

    private void begin() {
        while (fast < input.length) {
            if (Character.isWhitespace(input[fast])) {
                fast ++;
                continue;
            }

            if (isOperand()) {
                fast ++;
                continue;
            }

            if (isBracket()) {
                fast ++;
                continue;
            }

            if (isNumber()) {
                fast ++;
                continue;
            }

            throw new RuntimeException("Failed to convert char " + fast + " to a token. Allowed tokens are numbers " +
                    "(including hex/0x/0X and binary/0b/0B), operands (+, -, *, / and - (negate)) and brackets \"()\".");
        }
    }

    private boolean isOperand() {
        switch (input[fast]) {
            case '*' -> tokens.add(Binary.MULTIPLY);
            case '/' -> tokens.add(Binary.DIVIDE);
            case '+' -> tokens.add(Binary.ADD);
            case '-' -> {
                boolean isSubtract = tokens.isEmpty()
                        || getLastToken() instanceof Number
                        || getLastToken() instanceof Brackets bracket && bracket == Brackets.CLOSE;

                if (isSubtract) {
                    tokens.add(Binary.SUBTRACT);
                } else {
                    tokens.add(Unary.NEGATE);
                }
            }
            default -> {
                return false;
            }
        }

        return true;
    }

    boolean isBracket() {
        switch (input[fast]) {
            case '(' -> tokens.add(Brackets.OPEN);
            case ')' -> tokens.add(Brackets.CLOSE);
            default -> {
                return false;
            }
        }

        return true;
    }

    boolean isNumber() {
        final Pattern digits = Pattern.compile("[0-9]");
        if (!digits.matcher(inputString).find(fast)) {
            return false;
        }

        slow = fast;

        if (fast + 1 < input.length) {
            switch (input[fast + 1]) {
                case 'x', 'X' -> {
                    fast += 2;
                    if (fast >= input.length) {
                        throw new RuntimeException("Hex prefix with no following digits at the end of the string.");
                    }
                    parseHex();
                }
                case 'b', 'B' -> {
                    fast += 2;
                    if (fast >= input.length) {
                        throw new RuntimeException("Binary prefix with no following digits at the end of the string.");
                    }
                    parseBin();
                }
                default -> parseDec();
            }
        }

        return true;
    }

    private void parseHex() {
        final Pattern hexDigits = Pattern.compile("[0-9aAbBcCdDeEfF_,]+");
        addNumberToken(hexDigits);
    }

    private void parseBin() {
        final Pattern hexDigits = Pattern.compile("[0-1_,]+");
        addNumberToken(hexDigits);
    }

    private void parseDec() {
        final Pattern hexDigits = Pattern.compile("[0-9_,]+");
        addNumberToken(hexDigits);
    }

    private void addNumberToken(Pattern hexDigits) {
        Matcher matcher = hexDigits.matcher(inputString);
        boolean b = matcher.find(fast);
        assert b;

        fast = matcher.end();
        tokens.add(new Number(inputString.substring(slow, fast)));
        fast --;
    }


    private Primitive getLastToken() {
        return tokens.get(tokens.size() - 1);
    }

}
