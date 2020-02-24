package Tokenizer.Tokens;

public class StringToken implements Token {
    public final String name;
    public StringToken(final String name) {
        this.name = name;
    }
    public boolean equals(final Object other) {
        if (other instanceof StringToken) {
            StringToken otherVal = (StringToken) other;
            return name.equals(otherVal.name);
        } else
            return false;
    }
}
