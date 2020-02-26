package Tokenizer.Tokens;

public class IntegerToken implements Token {
    public final int number;

    public IntegerToken(final int number) {
        this.number = number;
    }

    public boolean equals(final Object other) {
        if (other instanceof IntegerToken) {
            final IntegerToken otherVal = (IntegerToken) other;
            return number == otherVal.number;
        } else
            return false;
    }
}
