package tree;

import tokens.Token;

/**
 * An Abstract Syntax Tree.
 */
public class AST extends Tree<Token, AST> {

    public AST() {
        super();
    }

    public AST(Token value) {
        super(value);
    }

    public AST(Token value, AST left) {
        super(value, left);
    }

    public AST(Token value, AST left, AST right) {
        super(value, left, right);
    }

}
