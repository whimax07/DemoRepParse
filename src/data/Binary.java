package data;

public enum Binary implements Operand, Primitive {
    ADD(3, true),
    SUBTRACT(3, true),
    MULTIPLY(5, true),
    DIVIDE(5, true);



    final int president;

    final boolean isLeftAssociative;



    Binary(int president, boolean isLeftAssociative) {
        this.president = president;
        this.isLeftAssociative = isLeftAssociative;
    }



    public int getPresident() {
        return president;
    }

    public boolean isLeftAssociative() {
        return isLeftAssociative;
    }

    /**
     * binary(this) > binary(y), if this has higher precedence than y, or this is left associative and this and y have
     * equal precedence.
     */
    public boolean evalBeforeY(Binary y) {
        return this.president > y.president || (this.isLeftAssociative && this.president == y.president);
    }

}
