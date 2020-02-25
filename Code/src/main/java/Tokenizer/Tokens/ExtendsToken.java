package Tokenizer.Tokens;


public class ExtendsToken implements Token {
    public boolean equals(final Object other) {
        return (other instanceof ExtendsToken);
    }
}
