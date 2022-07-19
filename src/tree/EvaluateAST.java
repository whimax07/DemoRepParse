package tree;

import tokens.*;

import java.util.HashSet;
import java.util.Stack;

public class EvaluateAST {

    public static java.lang.Number eval(AST in) {
        Token value = in.getValue();

        return switch (value) {
            case Binary binary -> binary.evaluate(eval(in.getLeft()), eval(in.getRight()));
            case Unary unary -> unary.evaluate(eval(in.getLeft()));
            case NumberToken numberToken -> numberToken.getNumeric();
            default -> throw new ArithmeticException("The AST had an argument it wasn't expecting. " + value);
        };
    }



//    public static Number evalStack(AST root) {
//        HashSet<State> processed = new HashSet<>();
//        Stack<State> pending = new Stack<>();
//        Number leftNumber = null;
//        Number rightNumber = null;
//
//        State base = new State(null, true);
//        pending.push(base);
//        pending.push(new State(root, true));
//
//        while (pending.peek() != base) {
//            AST node = pending.peek().ast();
//            boolean leftVal = pending.peek().left();
//
//
//            AST left = node.getLeft();
//            if (left != null) {
//                State pendingLeft = new State(left, true);
//
//                if (left.getValue() instanceof NumberToken numberToken) {
//                    leftNumber = numberToken.getNumeric();
//                } else if (!processed.contains(pendingLeft)) {
//                    pending.push(pendingLeft);
//                    processed.add(pendingLeft);
//                    continue;
//                }
//            }
//
//
//            AST right = node.getRight();
//            if (right != null) {
//                State pendingRight = new State(right, false);
//
//                if (right.getValue() instanceof NumberToken numberToken) {
//                    rightNumber = numberToken.getNumeric();
//                } else if (!processed.contains(pendingRight)) {
//                    pending.push(pendingRight);
//                    processed.add(pendingRight);
//                    continue;
//                }
//            }
//
//
//            switch (node.getValue()) {
//                case Binary binary -> {
//                    if (leftVal) {
//                        leftNumber = binary.evaluate(leftNumber, rightNumber);
//                    } else {
//                        rightNumber = binary.evaluate(leftNumber, rightNumber);
//                    }
//                    pending.pop();
//                }
//                case Unary unary -> {
//                    leftNumber = unary.evaluate(leftNumber);
//                    pending.pop();
//                }
//                default -> throw new IllegalStateException("Not expecting: " + pending.peek());
//            }
//
//            if (pending.size() > 5) {
//                System.out.println(pending);
//                throw new RuntimeException("Bad pending stack");
//            }
//        }
//
//        return leftNumber;
//    }



    private record State(AST ast, boolean left) {}

}
