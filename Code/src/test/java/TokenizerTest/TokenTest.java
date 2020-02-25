package TokenizerTest;

import Tokenizer.*;
import Tokenizer.Tokens.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.*;

public class TokenTest {

    public static void checkTokenizes(final String input,
                                      Token... expected) throws TokenizerException {
        final List<Token> expectedTokens = new ArrayList<>();
        for (final Token token : expected)
            expectedTokens.add(token);
        final Tokenizer testTokenizer = new Tokenizer(input);
        final List<Token> receivedTokens = testTokenizer.tokenize();
        Assertions.assertEquals(expectedTokens, receivedTokens);
    }
    @Test
    public void checkCorrectTokenizedInteger() throws TokenizerException {
        checkTokenizes("1234", new IntegerToken(1234));
    }
    @Test
    public void checkCorrectTokenizedIntegerWithSpaceBefore() throws TokenizerException {
        checkTokenizes(" 1234", new IntegerToken(1234));
    }
    @Test
    public void checkCorrectTokenizedIntegerWithSpaceAfter() throws TokenizerException {
        checkTokenizes("1234 ", new IntegerToken(1234));
    }
    @Test
    public void checkCorrectTokenizedTwoIntegers() throws TokenizerException {
        checkTokenizes("12 34", new IntegerToken(12), new IntegerToken(34));
    }
    @Test
    public void checkCorrectTokenizedString() throws TokenizerException {
        checkTokenizes("\"string\"", new StringToken("string"));
    }
    @Test
    public void checkCorrectTokenizedTwoStrings() throws TokenizerException {
        checkTokenizes("\"string\" \"string2\"",
                new StringToken("string"),
                new StringToken("string2"));
    }
    @Test
    public void checkCorrectTokenizedLParen() throws TokenizerException {
        checkTokenizes("(", new LeftParenToken());
    }
    @Test
    public void checkCorrectTokenizedRParen() throws TokenizerException {
        checkTokenizes(")", new RightParenToken());
    }
    @Test
    public void checkCorrectTokenizedLCurly() throws TokenizerException {
        checkTokenizes("{", new LeftCurlyToken());
    }
    @Test
    public void checkCorrectTokenizedRCurly() throws TokenizerException {
        checkTokenizes("}", new RightCurlyToken());
    }
    @Test
    public void checkCorrectTokenizedIf() throws TokenizerException {
        checkTokenizes("if", new IfToken());
    }
    @Test
    public void checkCorrectTokenizedElse() throws TokenizerException {
        checkTokenizes("else", new ElseToken());
    }
    @Test
    public void checkCorrectTokenizedBreak() throws TokenizerException {
        checkTokenizes("break", new BreakToken());
    }
    @Test
    public void checkCorrectTokenizedReturn() throws TokenizerException {
        checkTokenizes("return", new ReturnToken());
    }
    @Test
    public void checkCorrectTokenizedFor() throws TokenizerException {
        checkTokenizes("for", new ForToken());
    }
    @Test
    public void checkCorrectTokenizedWhile() throws TokenizerException {
        checkTokenizes("while", new WhileToken());
    }
    @Test
    public void checkCorrectTokenizedNewToken() throws TokenizerException {
        checkTokenizes("new", new NewToken());
    }
    @Test
    public void checkCorrectTokenizedExtendsToken() throws TokenizerException {
        checkTokenizes("extends", new ExtendsToken());
    }
    @Test
    public void checkCorrectTokenizedStringType() throws TokenizerException {
        checkTokenizes("String", new StringTypeToken());
    }
    @Test
    public void checkCorrectTokenizedIntType() throws TokenizerException {
        checkTokenizes("int", new IntTypeToken());
    }
    @Test
    public void checkCorrectTokenizedCharType() throws TokenizerException {
        checkTokenizes("char", new CharTypeToken());
    }
    @Test
    public void checkCorrectTokenizedBooleanType() throws TokenizerException {
        checkTokenizes("boolean", new BooleanTypeToken());
    }
    @Test
    public void checkCorrectTokenizedIdentifier() throws TokenizerException {
        checkTokenizes("ifelsewhile", new IdentifierToken("ifelsewhile"));
    }
    @Test
    public void checkCorrectTokenizedPlus() throws TokenizerException {
        checkTokenizes("+", new OperatorToken("+"));
    }
    @Test
    public void checkCorrectTokenizedMinus() throws TokenizerException {
        checkTokenizes("-", new OperatorToken("-"));
    }
    @Test
    public void checkCorrectTokenizedEquals() throws TokenizerException {
        checkTokenizes("=", new OperatorToken("="));
    }
    @Test
    public void checkCorrectTokenizedMultiply() throws TokenizerException {
        checkTokenizes("*", new OperatorToken("*"));
    }
    @Test
    public void checkCorrectTokenizedDivision() throws TokenizerException {
        checkTokenizes("/", new OperatorToken("/"));
    }
    @Test
    public void checkCorrectTokenizedNegation() throws TokenizerException {
        checkTokenizes("!", new OperatorToken("!"));
    }
    @Test
    public void checkCorrectTokenizedModulo() throws TokenizerException {
        checkTokenizes("%", new OperatorToken("%"));
    }
    @Test
    public void checkCorrectTokenizedGreaterThan() throws TokenizerException {
        checkTokenizes(">", new OperatorToken(">"));
    }
    @Test
    public void checkCorrectTokenizedLessThan() throws TokenizerException {
        checkTokenizes("<", new OperatorToken("<"));
    }
    @Test
    public void checkCorrectTokenizedAnd() throws TokenizerException {
        checkTokenizes("&&", new OperatorToken("&&"));
    }
    @Test
    public void checkNotTokenizeSingleAnd() {
        final String test = "&";
        final Tokenizer testTokenizer = new Tokenizer(test);
        Assertions.assertThrows(TokenizerException.class, testTokenizer::tokenize);
    }
    @Test
    public void checkCorrectTokenizedOr() throws TokenizerException {
        checkTokenizes("||", new OperatorToken("||"));
    }
    @Test
    public void checkNotTokenizeSingleBar() {
        final String test = "|";
        final Tokenizer testTokenizer = new Tokenizer(test);
        Assertions.assertThrows(TokenizerException.class, testTokenizer::tokenize);
    }
    @Test
    public void checkCorrectTokenizedGreaterThanEquals() throws TokenizerException {
        checkTokenizes(">=", new OperatorToken(">="));
    }
    @Test
    public void checkCorrectTokenizedLessThanEquals() throws TokenizerException {
        checkTokenizes("<=", new OperatorToken("<="));
    }
    @Test
    public void checkCorrectTokenizedReferenceEquals() throws TokenizerException {
        checkTokenizes("==", new OperatorToken("=="));
    }
    @Test
    public void checkCorrectTokenizedDot() throws TokenizerException {
        checkTokenizes(".", new DotToken());
    }
    @Test
    public void checkCorrectTokenizedSemiColon() throws TokenizerException {
        checkTokenizes(";", new SemiColonToken());
    }
    @Test
    public void checkThrowsExceptionWhitespaceInput() {
        final String testString = " ";
        final Tokenizer testTokenizer = new Tokenizer(testString);
        Assertions.assertThrows(TokenizerException.class,
                testTokenizer::tokenize);
    }
    @Test
    public void checkThrowsExceptionEmptyInput() {
        final String testString = "";
        final Tokenizer testTokenizer = new Tokenizer(testString);
        Assertions.assertThrows(TokenizerException.class,
                testTokenizer::tokenize);
    }
}
