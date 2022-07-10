package tree;

import tokens.Token;

/**
 * An Abstract Syntax Tree.
 */
public class AST extends Tree<Token> {

    public AST(Token value) {
        super(value);
    }

    public AST(Token value, Tree<Token> left) {
        super(value, left);
    }

    public AST(Token value, Tree<Token> left, Tree<Token> right) {
        super(value, left, right);
    }





}
