package Tokenizer.Tokens;

import Tokenizer.Tokenizer;

public class OperatorToken implements Token {
    public final String name;

    public OperatorToken(final String name) {
        this.name = name;
    }
}
