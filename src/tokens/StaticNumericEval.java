package tokens;

public class StaticNumericEval {

    public static double eval(Binary operator, double operand1, double operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static double eval(Binary operator, double operand1, float operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static double eval(Binary operator, double operand1, long operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static double eval(Binary operator, double operand1, int operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static double eval(Binary operator, double operand1, short operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static double eval(Binary operator, double operand1, byte operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }



    public static double eval(Binary operator, float operand1, double operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static float eval(Binary operator, float operand1, float operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static float eval(Binary operator, float operand1, long operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static float eval(Binary operator, float operand1, int operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static float eval(Binary operator, float operand1, short operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static float eval(Binary operator, float operand1, byte operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }



    public static double eval(Binary operator, long operand1, double operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static float eval(Binary operator, long operand1, float operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static long eval(Binary operator, long operand1, long operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static long eval(Binary operator, long operand1, int operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static long eval(Binary operator, long operand1, short operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static long eval(Binary operator, long operand1, byte operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }



    public static double eval(Binary operator, int operand1, double operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static float eval(Binary operator, int operand1, float operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static long eval(Binary operator, int operand1, long operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static int eval(Binary operator, int operand1, int operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static int eval(Binary operator, int operand1, short operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static int eval(Binary operator, int operand1, byte operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }



    public static double eval(Binary operator, short operand1, double operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static float eval(Binary operator, short operand1, float operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static long eval(Binary operator, short operand1, long operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static int eval(Binary operator, short operand1, int operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static short eval(Binary operator, short operand1, short operand2) {
        return switch (operator) {
            case ADD -> (short) (operand1 + operand2);
            case MULTIPLY -> (short) (operand1 * operand2);
            case SUBTRACT -> (short) (operand1 - operand2);
            case DIVIDE -> (short) (operand1 / operand2);
        };
    }

    public static short eval(Binary operator, short operand1, byte operand2) {
        return switch (operator) {
            case ADD -> (short) (operand1 + operand2);
            case MULTIPLY -> (short) (operand1 * operand2);
            case SUBTRACT -> (short) (operand1 - operand2);
            case DIVIDE -> (short) (operand1 / operand2);
        };
    }



    public static double eval(Binary operator, byte operand1, double operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static float eval(Binary operator, byte operand1, float operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static long eval(Binary operator, byte operand1, long operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static int eval(Binary operator, byte operand1, int operand2) {
        return switch (operator) {
            case ADD -> operand1 + operand2;
            case MULTIPLY -> operand1 * operand2;
            case SUBTRACT -> operand1 - operand2;
            case DIVIDE -> operand1 / operand2;
        };
    }

    public static short eval(Binary operator, byte operand1, short operand2) {
        return switch (operator) {
            case ADD -> (short) (operand1 + operand2);
            case MULTIPLY -> (short) (operand1 * operand2);
            case SUBTRACT -> (short) (operand1 - operand2);
            case DIVIDE -> (short) (operand1 / operand2);
        };
    }

    public static byte eval(Binary operator, byte operand1, byte operand2) {
        return switch (operator) {
            case ADD -> (byte) (operand1 + operand2);
            case MULTIPLY -> (byte) (operand1 * operand2);
            case SUBTRACT -> (byte) (operand1 - operand2);
            case DIVIDE -> (byte) (operand1 / operand2);
        };
    }

}
