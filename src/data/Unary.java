package data;

public enum Unary implements Operand, Primitive {
    NEGATE(4);



    final int president;



    Unary(int president) {
        this.president = president;
    }



    public int getPresident() {
        return president;
    }

    /**
     * unary(this) > binary(y), if x has precedence higher or equal to y's.
     */
    public boolean evalBeforeY(Binary y) {
        return this.president >= y.president;
    }
}
