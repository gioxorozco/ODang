package Tokenizer.Tokens;

public class RightParenToken implements Token {
    public boolean equals(final Object other) {
        return (other instanceof RightParenToken);
    }
}
