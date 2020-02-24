package Tokenizer.Tokens;

public class IfToken implements Token {
    public boolean equals(final Object other) {
        return (other instanceof IfToken);
    }
}
