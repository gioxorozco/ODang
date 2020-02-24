package Tokenizer.Tokens;

public class ClassToken implements Token {
    public boolean equals(final Object other) {
        return (other instanceof ClassToken);
    }
}
