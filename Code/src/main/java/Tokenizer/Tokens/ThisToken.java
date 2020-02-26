package Tokenizer.Tokens;

public class ThisToken implements Token {
    public boolean equals(final Object other) {
        return (other instanceof ThisToken);
    }
}
