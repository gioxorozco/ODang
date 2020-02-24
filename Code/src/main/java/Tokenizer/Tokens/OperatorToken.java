package Tokenizer.Tokens;

public class OperatorToken implements Token {
    public final String name;

    public OperatorToken(final String name) {
        this.name = name;
    }

    public boolean equals(final Object other) {
        if (other instanceof OperatorToken) {
            OperatorToken otherVal = (OperatorToken) other;
            return name.equals(otherVal.name);
        } else
            return false;
    }
}
