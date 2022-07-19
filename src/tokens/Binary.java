package tokens;

public enum Binary implements Operator, Token {
    ADD(3, true),
    SUBTRACT(3, true),
    MULTIPLY(5, true),
    DIVIDE(5, true);



    final int precedence;

    final boolean isLeftAssociative;



    Binary(int president, boolean isLeftAssociative) {
        this.precedence = president;
        this.isLeftAssociative = isLeftAssociative;
    }



    public int getPrecedence() {
        return precedence;
    }

    public boolean isLeftAssociative() {
        return isLeftAssociative;
    }

    public <T extends java.lang.Number> java.lang.Number evaluate(T operand1, T operand2) {
        return switch (operand1) {
            case Double d -> eval(d, operand2);
            case Float f -> eval(f, operand2);
            case Long l -> eval(l, operand2);
            case Integer i -> eval(i, operand2);
            case Short s -> eval(s, operand2);
            case Byte b -> eval(b, operand2);
            default -> throw new IllegalStateException(
                    "Unexpected value: " + operand1 + " Type: " + operand1.getClass() + "."
            );
        };
    }



    private <T extends java.lang.Number> java.lang.Number eval(Double aDouble, T operand2) {
        return switch (operand2) {
            case Double d -> StaticNumericEval.eval(this, aDouble, d);
            case Float f -> StaticNumericEval.eval(this, aDouble, f);
            case Long l -> StaticNumericEval.eval(this, aDouble, l);
            case Integer i -> StaticNumericEval.eval(this, aDouble, i);
            case Short s -> StaticNumericEval.eval(this, aDouble, s);
            case Byte b -> StaticNumericEval.eval(this, aDouble, b);
            default -> throw new IllegalStateException(
                    "Unexpected value: " + operand2 + " Type: " + operand2.getClass() + "."
            );
        };
    }

    private <T extends java.lang.Number> java.lang.Number eval(Float aFloat, T operand2) {
        return switch (operand2) {
            case Double d -> StaticNumericEval.eval(this, aFloat, d);
            case Float f -> StaticNumericEval.eval(this, aFloat, f);
            case Long l -> StaticNumericEval.eval(this, aFloat, l);
            case Integer i -> StaticNumericEval.eval(this, aFloat, i);
            case Short s -> StaticNumericEval.eval(this, aFloat, s);
            case Byte b -> StaticNumericEval.eval(this, aFloat, b);
            default -> throw new IllegalStateException(
                    "Unexpected value: " + operand2 + " Type: " + operand2.getClass() + "."
            );
        };
    }

    private <T extends java.lang.Number> java.lang.Number eval(Long aLong, T operand2) {
        return switch (operand2) {
            case Double d -> StaticNumericEval.eval(this, aLong, d);
            case Float f -> StaticNumericEval.eval(this, aLong, f);
            case Long l -> StaticNumericEval.eval(this, aLong, l);
            case Integer i -> StaticNumericEval.eval(this, aLong, i);
            case Short s -> StaticNumericEval.eval(this, aLong, s);
            case Byte b -> StaticNumericEval.eval(this, aLong, b);
            default -> throw new IllegalStateException(
                    "Unexpected value: " + operand2 + " Type: " + operand2.getClass() + "."
            );
        };
    }

    private <T extends java.lang.Number> java.lang.Number eval(Integer aInteger, T operand2) {
        return switch (operand2) {
            case Double d -> StaticNumericEval.eval(this, aInteger, d);
            case Float f -> StaticNumericEval.eval(this, aInteger, f);
            case Long l -> StaticNumericEval.eval(this, aInteger, l);
            case Integer i -> StaticNumericEval.eval(this, aInteger, i);
            case Short s -> StaticNumericEval.eval(this, aInteger, s);
            case Byte b -> StaticNumericEval.eval(this, aInteger, b);
            default -> throw new IllegalStateException(
                    "Unexpected value: " + operand2 + " Type: " + operand2.getClass() + "."
            );
        };
    }

    private <T extends java.lang.Number> java.lang.Number eval(Short aShort, T operand2) {
        return switch (operand2) {
            case Double d -> StaticNumericEval.eval(this, aShort, d);
            case Float f -> StaticNumericEval.eval(this, aShort, f);
            case Long l -> StaticNumericEval.eval(this, aShort, l);
            case Integer i -> StaticNumericEval.eval(this, aShort, i);
            case Short s -> StaticNumericEval.eval(this, aShort, s);
            case Byte b -> StaticNumericEval.eval(this, aShort, b);
            default -> throw new IllegalStateException(
                    "Unexpected value: " + operand2 + " Type: " + operand2.getClass() + "."
            );
        };
    }

    private <T extends java.lang.Number> java.lang.Number eval(Byte aByte, T operand2) {
        return switch (operand2) {
            case Double d -> StaticNumericEval.eval(this, aByte, d);
            case Float f -> StaticNumericEval.eval(this, aByte, f);
            case Long l -> StaticNumericEval.eval(this, aByte, l);
            case Integer i -> StaticNumericEval.eval(this, aByte, i);
            case Short s -> StaticNumericEval.eval(this, aByte, s);
            case Byte b -> StaticNumericEval.eval(this, aByte, b);
            default -> throw new IllegalStateException(
                    "Unexpected value: " + operand2 + " Type: " + operand2.getClass() + "."
            );
        };
    }

}
