package tokens;

public enum Unary implements Operator, Token {
    NEGATE(4);



    final int president;



    Unary(int president) {
        this.president = president;
    }



    public int getPresident() {
        return president;
    }

}
