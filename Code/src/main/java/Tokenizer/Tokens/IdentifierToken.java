package Tokenizer.Tokens;

public class IdentifierToken implements Token {
    public final String name;

    public IdentifierToken(final String name) {
        this.name = name;
    }

}
