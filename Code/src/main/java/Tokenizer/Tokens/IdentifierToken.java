package Tokenizer.Tokens;

public class IdentifierToken implements Token {
    public final String name;

    public IdentifierToken(final String name) {
        this.name = name;
    }

    public boolean equals(final Object other) {
        if (other instanceof IdentifierToken) {
            final IdentifierToken otherVal = (IdentifierToken) other;
            return name.equals(otherVal.name);
        } else
            return false;
    }
}
