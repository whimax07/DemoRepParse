import data.*;

import java.util.ArrayList;
import java.util.Stack;

/**
 * An implementation from https://www.engr.mun.ca/~theo/Misc/exp_parsing.htm
 */
public class DemoRepParse {

    private ArrayList<Primitive> primitives;

    private int currentPosition = 0;

    private Stack<Operand> operators = new Stack<>();

    private Stack<Tree<Primitive>> operands = new Stack<>();



    public void parse(String toParse) {
        primitives = Tokenizer.tokenizer(toParse);
    }



    private Primitive next() {
        if (currentPosition + 1 < primitives.size()) {
            return primitives.get(currentPosition);
        } else {
            return new End();
        }
    }

    private void consume() {

    }


    private Tree<Primitive> makeLeaf(Primitive value) {
        return new Tree<>(value);
    }

    private Tree<Primitive> makeNode(Unary unaryOperator, Tree<Primitive> value) {
        return new Tree<>(unaryOperator, value);
    }

    private Tree<Primitive> makeNode(Binary binaryOperator, Tree<Primitive> value1, Tree<Primitive> value2) {
        return new Tree<>(binaryOperator, value1, value2);
    }


    private void error() {

    }

}


/*
"next" returns the next token of input or special marker "end" to represent that there are no more input tokens. "next" does not alter the input stream.
"consume" reads one token. When "next=end", consume is still allowed, but has no effect.
"error" stops the parsing process and reports an error.
 */

/*
"binary" converts a token matched by B to an operator.
"unary" converts a token matched by U to an operator. We require that functions "unary" and "binary" have disjoint
        ranges. (For example unary("-") and binary("-") are not equal.)
"mkLeaf" converts a token matched by v to a tree.
"mkNode" takes an operator and one or two trees and returns a tree.
"push", "pop", "top": the usual stack operations.
"empty": an empty stack
"sentinel" is a value that is not in the range of either unary or binary.
 */

/*
binary(x) > binary(y), if x has higher precedence than y, or x is left associative and x and y have equal precedence.
unary(x) > binary(y), if x has precedence higher or equal to y's
op > unary(y), never (where op is any unary or binary operator)
sentinel > op, never (where op is any unary or binary operator)
op > sentinel  (where op is any unary or binary operator): This case doesn't arise.
 */

/*
    Eparser is
       var operators : Stack of Operator := empty
       var operands : Stack of Tree := empty
       push( operators, sentinel )
       E( operators, operands )
       expect( end )
       return top( operands )
 */

/*
    E( operators, operands ) is
        P( operators, operands )
        while next is a binary operator
           pushOperator( binary(next), operators, operands )
           consume
           P( operators, operands )
        while top(operators) not= sentinel
           popOperator( operators, operands )
 */

/*

    P( operators, operands ) is
        if next is a v
             push( operands, mkLeaf( v ) )
             consume
        else if next = "("
             consume
             push( operators, sentinel )
             E( operators, operands )
             expect( ")" )
             pop( operators )
        else if next is a unary operator
             pushOperator( unary(next), operators, operands )
             consume
             P( operators, operands )
        else
             error
 */

/*
    popOperator( operators, operands ) is
       if top(operators) is binary
            const t1 := pop( operands )
            const t0 := pop( operands )
            push( operands, mkNode( pop(operators), t0, t1 ) )
       else
            push( operands, mkNode( pop(operators), pop(operands) ) )
 */

/*

    pushOperator( op, operators, operands ) is
        while top(operators) > op
           popOperator( operators, operands )
        push( op, operators )
 */
