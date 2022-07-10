package tokens;

public enum Binary implements Operator, Token {
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

}
