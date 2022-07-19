package tokens;

public class NumberToken implements Token {

    private final String stringValue;

    private final NumericType numericType;

    private final Format format;

    private final java.lang.Number numericValue;



    public NumberToken(String stringValue) {
        this.stringValue = stringValue;

        if (stringValue.startsWith("0x") || stringValue.startsWith("0X")) {
            format = Format.HEX;
        } else if (stringValue.startsWith("0b") || stringValue.startsWith("0B")) {
            format = Format.BIN;
        } else {
            format = Format.DEC;
        }

        if (stringValue.contains(".")) {
            numericType = NumericType.DOUBLE;
        } else {
            numericType = NumericType.LONG;
        }

        numericValue = parseNum();
    }

    public NumberToken(java.lang.Number numericValue) {
        this.numericValue = numericValue;

        this.format = Format.DEC;
        this.stringValue = null;

        numericType = switch (numericValue) {
            case Double ignored -> NumericType.DOUBLE;
            case Float ignored -> NumericType.FLOAT;
            case Long ignored -> NumericType.LONG;
            case Integer ignored -> NumericType.INT;
            case Short ignored -> NumericType.SHORT;
            case Byte ignored -> NumericType.BYTE;
            default -> throw new IllegalStateException(
                    "Unexpected value: " + numericValue + " Type: " + numericValue.getClass() + "."
            );
        };
    }

    private java.lang.Number parseNum() {
        switch (numericType) {
            case DOUBLE, FLOAT -> {
                return switch (format) {
                    case DEC -> Double.parseDouble(stringValue);
                    case HEX, BIN -> throw new IllegalStateException("Value cannot be " + numericType + " and " + format + ".");
                };
            }
            case LONG, INT, SHORT, BYTE -> {
                String trimmed = stringValue.replaceFirst("^0[xXbB]", "");
                return switch (format) {
                    case HEX -> Long.parseLong(trimmed, 16);
                    case DEC -> Long.parseLong(trimmed, 10);
                    case BIN -> Long.parseLong(trimmed, 2);
                };
            }
        }

        throw new IllegalStateException("Configuration was not court " + numericType + " and " + format + ".");
    }



    public java.lang.Number getNumeric() {
        return numericValue;
    }



    @Override
    public String toString() {
        return "Number{" +
                "stringValue='" + stringValue + '\'' +
                ", numericType=" + numericType +
                ", format=" + format +
                ", numericValue=" + numericValue +
                '}';
    }

}
