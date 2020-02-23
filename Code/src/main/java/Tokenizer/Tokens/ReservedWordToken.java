package Tokenizer.Tokens;

public class ReservedWordToken implements Token {
    public final String name;

    public ReservedWordToken(final String name) {
        this.name = name;
    }
}
