package tokens;

@SuppressWarnings("SwitchStatementWithTooFewBranches")
public enum Unary implements Operator, Token {
    NEGATE(4);



    final int precedence;



    Unary(int precedence) {
        this.precedence = precedence;
    }



    public int getPrecedence() {
        return precedence;
    }

    public <T extends java.lang.Number> java.lang.Number evaluate(T operand) {
        return switch (operand) {
            case Double d -> eval(d);
            case Float f -> eval(f);
            case Long l -> eval(l);
            case Integer i -> eval(i);
            case Short s -> eval(s);
            case Byte b -> eval(b);
            default -> throw new IllegalStateException(
                    "Unexpected value: " + operand + " Type: " + operand.getClass() + "."
            );
        };
    }



    private double eval(double operand) {
        return switch (this) {
            case NEGATE -> -operand;
        };
    }

    private float eval(float operand) {
        return switch (this) {
            case NEGATE -> -operand;
        };
    }

    private long eval(long operand) {
        return switch (this) {
            case NEGATE -> -operand;
        };
    }

    private int eval(int operand) {
        return switch (this) {
            case NEGATE -> -operand;
        };
    }

    private short eval(short operand) {
        return switch (this) {
            case NEGATE -> (short) -operand;
        };
    }

    private byte eval(byte operand) {
        throw new IllegalStateException(
                "Cannot apple: " + this + " to " + operand + "of type " + Byte.class + "."
        );
    }

}
