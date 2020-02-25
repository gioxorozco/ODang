package Tokenizer.Tokens;

public class IntTypeToken implements Token {
    public boolean equals(final Object other) {
        return (other instanceof IntTypeToken);
    }
}
