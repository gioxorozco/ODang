package Tokenizer.Tokens;

public class NewToken implements Token {
    public boolean equals(final Object other) {
        return (other instanceof NewToken);
    }
}
