package data;

public interface Operand {

    default boolean evalBeforeY(Unary y) {
        return false;
    }

}
