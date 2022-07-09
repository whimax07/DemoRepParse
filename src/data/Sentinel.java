package data;

public enum Sentinel implements Operand, Primitive {
    SENTINEL;


    /**
     * sentinel > op, never (where op is any unary or binary operator).
     */
    public boolean evalBeforeY(Operand y) {
        return false;
    }
}
