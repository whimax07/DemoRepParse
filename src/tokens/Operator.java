package tokens;

import java.text.ParseException;

public interface Operator {

    static boolean comparePrecedence(Operator operator1, Operator operator2) throws ParseException {
        if (operator1 instanceof Binary b1 && operator2 instanceof Binary b2) {
            return b1.president > b2.president || b1.isLeftAssociative && b1.president == b2.president;
        }

        if (operator1 instanceof Unary unary && operator2 instanceof Binary binary) {
            return unary.president >= binary.president;
        }

        if (operator2 instanceof Unary unary) {
            return false;
        }

        if (operator1 instanceof Sentinel sentinel) {
            return false;
        }

        if (operator2 instanceof Sentinel sentinel) {
            return true;
        }

        throw new ParseException("Cannot establish what the precedence order of " + operator1 + " and " + operator2
                + ".", -1);
    }

}
