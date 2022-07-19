import tokens.*;
import tokens.NumberToken;
import tree.AST;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Stack;

/**
 * An implementation from <a href="https://www.engr.mun.ca/~theo/Misc/exp_parsing.htm">Parsing Expressions by Recursive
 * Descent Theodore Norvell (C) 1999 with updates later on.</a>
 */
public class DemoRepParse {

    private ArrayList<Token> tokens;

    private int currentPosition = 0;

    private Stack<Operator> operators = new Stack<>();

    private Stack<AST> operands = new Stack<>();



    private void cleanClass() {
        tokens = new ArrayList<>();
        currentPosition = 0;
        operators = new Stack<>();
        operands = new Stack<>();
    }



    boolean isCorrectGrammar(String toCheck) throws ParseException {
        cleanClass();

        if (toCheck.isBlank()) {
            return true;
        }

        tokens = Tokenizer.tokenizer(toCheck);
        currentPosition = 0;

        checkE();
        expect(End.END);
        return true;
    }

    private void checkE() throws ParseException {
        checkP();
        while (next() instanceof Binary) {
            consume();
            checkP();
        }
    }

    private void checkP() throws ParseException {
        switch (next()) {
            case NumberToken numberToken -> consume();
            case Brackets brackets && brackets == Brackets.OPEN -> {
                consume();
                checkE();
                expect(Brackets.CLOSE);
            }
            case Unary unary -> {
                consume();
                checkP();
            }
            default -> throw new ParseException("Failed to match " + next() + " to a token expected by the grammar.",
                    currentPosition);
        }
    }



    public AST parse(String toParse) throws ParseException {
        cleanClass();

        if (toParse.isBlank()) {
            return new AST();
        }

        tokens = Tokenizer.tokenizer(toParse);

        operators.push(Sentinel.SENTINEL);
        parseE();
        expect(End.END);
        return operands.peek();
    }

    private void parseE() throws ParseException {
        parseP();
        while (next() instanceof Binary binary) {
            pushOperator(binary);
            consume();
            parseP();
        }

        while (operators.peek() != Sentinel.SENTINEL) {
            popOperator();
        }
    }

    private void parseP() throws ParseException {
        switch (next()) {
            case NumberToken numberToken -> {
                operands.push(makeLeaf(numberToken));
                consume();
            }
            case Brackets brackets && brackets == Brackets.OPEN -> {
                consume();
                operators.push(Sentinel.SENTINEL);
                parseE();
                expect(Brackets.CLOSE);
                operators.pop();
            }
            case Unary unary -> {
                pushOperator(unary);
                consume();
                parseP();
            }
            default -> throw new ParseException("Unexpected token type: " + next() + ".", currentPosition);
        }
    }

    private void pushOperator(Operator operator) throws ParseException {
        while (Operator.comparePrecedence(operators.peek(), operator)) {
            popOperator();
        }
        operators.push(operator);
    }

    private void popOperator() throws ParseException {
        Operator operator = operators.pop();
        switch (operator) {
            case Binary binary -> {
                AST operand2 = operands.pop();
                AST operand1 = operands.pop();

                operands.push(makeNode(binary, operand1, operand2));
            }
            case Unary unary -> {
                AST operand = operands.pop();

                operands.push(makeNode(unary, operand));
            }
            default -> throw new ParseException("Recived a operator that wasn't Binary or Unary. " + operator, 
                    currentPosition);
        }
    }



    private void expect(Token token) throws ParseException {
        if (next() == token) {
            consume();
        } else {
            throw new ParseException("Expected: " + token + "\nFound: " + next(), currentPosition);
        }
    }

    private Token next() {
        if (currentPosition < tokens.size()) {
            return tokens.get(currentPosition);
        } else {
            return End.END;
        }
    }

    private void consume() {
        currentPosition ++;
    }

    private AST makeLeaf(Token value) {
        return new AST(value);
    }

    private AST makeNode(Unary unaryOperator, AST value) {
        return new AST(unaryOperator, value);
    }

    private AST makeNode(Binary binaryOperator, AST value1, AST value2) {
        return new AST(binaryOperator, value1, value2);
    }

}
