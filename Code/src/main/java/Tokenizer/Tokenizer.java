package Tokenizer;

import Tokenizer.Tokens.*;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.*;

public class Tokenizer {

    private final char[] input;
    private int inputPos;

    public Tokenizer(final char[] input) {
        this.input = input;
        inputPos = 0;
    }

    /**
     * Checks the current position in the list, done a lot in this code
     * so wrote a method for it
     * @return true or false depending on current position on the list
     */
    private boolean validPosition() {
        return inputPos < input.length;
    }

    /**
     * tries to tokenize an operator or paren
     * @TODO finish adding operators
     * @return Token or null
     */
    private Token tryTokenizeOperatorOrParen() {
        String symbols = "";

        //regex containing the valid operators in the language
        if(validPosition() &&
                String.valueOf(input[inputPos]).matches("[(){}+=\\-*/!%><&|]")) {

            symbols += input[inputPos];
            inputPos++;

            switch (symbols) {
                case "(":
                    return new LeftParenToken();
                case ")":
                    return new RightParenToken();
                case "{":
                    return new LeftCurlyToken();
                case "}":
                    return new RightCurlyToken();
                case "&":
                    if (input[inputPos] == '&') {
                        inputPos++;
                        return new OperatorToken("&&");
                    } else return null;
                case "|":
                    if (input[inputPos] == '|') {
                        inputPos++;
                        return new OperatorToken("||");
                    } else return null;
                case "<":
                    if(input[inputPos] == '=') {
                        inputPos++;
                        return new OperatorToken(("<="));
                    }
                case ">":
                    if (input[inputPos] == '=') {
                        inputPos++;
                        return new OperatorToken((">="));
                    }
                case "=":
                    if (input[inputPos] == '=') {
                        inputPos++;
                        return new OperatorToken(("=="));
                    }
                default:
                    return new OperatorToken(symbols);
            }
        } else {
            return null;
        }
    }

    /**
     * @TODO finish adding reserved words
     * @return ReservedWordToken or null
     */
    private Token tryTokenizeReservedWordOrVar() {
        String letters = "";

        if(validPosition() && Character.isLetter(input[inputPos])) {
            letters += input[inputPos];
            inputPos++;
            while (validPosition() && Character.isLetterOrDigit(input[inputPos])) {
                letters += input[inputPos];
                inputPos++;
            }
            switch (letters) {
                case "if":
                    return new IfToken();
                case "for":
                    return new ForToken();
                case "else":
                    return new ElseToken();
                case "while":
                    return new WhileToken();
                case "return":
                    return new ReturnToken();
                case "class":
                    return new ClassToken();
                case "break":
                    return new BreakToken();
                default:
                    return new VariableToken(letters);
            }

        } else {
            return null;
        }
    }

    /**
     * Tries to tokenize a char sequence as a variable
     * @return VariableToken or null
     */
    @Deprecated
    private VariableToken tryTokenizeVariable() {
        String letters = "";

        if (validPosition() && Character.isLetter(input[inputPos])) {
            letters += input[inputPos];
            inputPos++;

            while (validPosition() && Character.isLetterOrDigit(input[inputPos])) {
                letters += input[inputPos];
                inputPos++;
            }
            return new VariableToken(letters);
        } else {
            return null;
        }

    }

    /**
     * Tries to tokenize a char sequence as an integer
     * @return
     */
    private IntegerToken tryTokenizeInt() {
        String digits = "";

        //special case for negative numbers
        if (validPosition() && input[inputPos] == '-') {
            digits += input[inputPos];
            inputPos++;
        }
        while (validPosition() && Character.isDigit(input[inputPos])) {
            digits += input[inputPos];
            inputPos++;
        }

        if (digits.length() > 0) {
            return new IntegerToken(Integer.parseInt(digits));
        } else {
            return null;
        }

    }

    /**
     * tries to create a token
     * @return valid token
     * @throws TokenizerException if no valid token is found
     */
    private Token createToken() throws TokenizerException {
        Token token = tryTokenizeOperatorOrParen();
        while(true) {
            if (token == null) {
                token = tryTokenizeReservedWordOrVar();
            }
            if (token == null) {
                token = tryTokenizeInt();
            }
            if (token == null) {
                throw new TokenizerException("Not a valid token");
            }
            return token;
        }
    }

    /**
     * skips whitespace in the input
     */
    private void skipWhitespace() {
        while (validPosition() &&
                Character.isWhitespace(input[inputPos])) {
            inputPos++;
        }
    }

    /**
     * tokenizes a string input
     * @return List<Token> if successful
     * @throws TokenizerException if invalid input
     */
    public List<Token> tokenize() throws TokenizerException {
        List<Token> tokens = new ArrayList<Token>();

        while(validPosition()) {
            skipWhitespace();
            if(validPosition()) {
                tokens.add(createToken());
            }
        }
        if (tokens.isEmpty())
            throw new TokenizerException("Invalid Input?");
        else return tokens;
    }

    //main for testing purposes
    public static void main(String[] args) {
        String testString = "if ( x == 10) { return x - 132 }";
        Tokenizer testTokenizer = new Tokenizer(testString.toCharArray());
        try {
            List<Token> result = testTokenizer.tokenize();
            System.out.println(result);
        }
        catch (Exception e) {
            System.out.println("Found Exception: " + e);
        }

    }
}
