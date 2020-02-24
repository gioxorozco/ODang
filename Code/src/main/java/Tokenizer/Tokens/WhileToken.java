package Tokenizer.Tokens;

public class WhileToken implements Token {
    public boolean equals(final Object other) {
        return (other instanceof WhileToken);
    }
}
