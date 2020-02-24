package TokenizerTest;

import Tokenizer.*;
import Tokenizer.Tokens.*;
import java.util.List;
import org.junit.jupiter.api.*;

public class TokenTest {

    @Test
    public void checkCorrectTokenizedInteger() throws TokenizerException {
        final String testInt = "1234";
        final Tokenizer testTokenizer = new Tokenizer(testInt.toCharArray());
        final List<Token> testList = testTokenizer.tokenize();
        Assertions.assertEquals(IntegerToken.class, testList.get(0).getClass());
    }

    @Test
    public void checkCorrectTokenizedString() throws TokenizerException {
        final String testString = "\"string\"";
        final Tokenizer testTokenizer = new Tokenizer(testString.toCharArray());
        final List<Token> testList = testTokenizer.tokenize();
        Assertions.assertEquals(StringToken.class, testList.get(0).getClass());
    }
    @Test
    public void checkCorrectTokenizedLParen() throws TokenizerException {
        final String test = "(";
        final Tokenizer testTokenizer = new Tokenizer(test.toCharArray());
        final List<Token> testList = testTokenizer.tokenize();
        Assertions.assertEquals(LeftParenToken.class, testList.get(0).getClass());
    }
    @Test
    public void checkCorrectTokenizedRParen() throws TokenizerException {
        final String test = ")";
        final Tokenizer testTokenizer = new Tokenizer(test.toCharArray());
        final List<Token> testList = testTokenizer.tokenize();
        Assertions.assertEquals(RightParenToken.class, testList.get(0).getClass());
    }
    @Test
    public void checkCorrectTokenizedLCurly() throws TokenizerException {
        final String test = "{";
        final Tokenizer testTokenizer = new Tokenizer(test.toCharArray());
        final List<Token> testList = testTokenizer.tokenize();
        Assertions.assertEquals(LeftCurlyToken.class, testList.get(0).getClass());
    }
    @Test
    public void checkCorrectTokenizedRCurly() throws TokenizerException {
        final String test = "}";
        final Tokenizer testTokenizer = new Tokenizer(test.toCharArray());
        final List<Token> testList = testTokenizer.tokenize();
        Assertions.assertEquals(RightCurlyToken.class, testList.get(0).getClass());
    }
    @Test
    public void checkCorrectTokenizedIf() throws TokenizerException {
        final String test = "if";
        final Tokenizer testTokenizer = new Tokenizer(test.toCharArray());
        final List<Token> testList = testTokenizer.tokenize();
        Assertions.assertEquals(IfToken.class, testList.get(0).getClass());
    }
    @Test
    public void checkCorrectTokenizedElse() throws TokenizerException {
        final String test = "else";
        final Tokenizer testTokenizer = new Tokenizer(test.toCharArray());
        final List<Token> testList = testTokenizer.tokenize();
        Assertions.assertEquals(ElseToken.class, testList.get(0).getClass());
    }
    @Test
    public void checkCorrectTokenizedBreak() throws TokenizerException {
        final String test = "break";
        final Tokenizer testTokenizer = new Tokenizer(test.toCharArray());
        final List<Token> testList = testTokenizer.tokenize();
        Assertions.assertEquals(BreakToken.class, testList.get(0).getClass());
    }
    @Test
    public void checkCorrectTokenizedReturn() throws TokenizerException {
        final String test = "return";
        final Tokenizer testTokenizer = new Tokenizer(test.toCharArray());
        final List<Token> testList = testTokenizer.tokenize();
        Assertions.assertEquals(ReturnToken.class, testList.get(0).getClass());
    }
    @Test
    public void checkCorrectTokenizedFor() throws TokenizerException {
        final String test = "for";
        final Tokenizer testTokenizer = new Tokenizer(test.toCharArray());
        final List<Token> testList = testTokenizer.tokenize();
        Assertions.assertEquals(ForToken.class, testList.get(0).getClass());
    }
    @Test
    public void checkCorrectTokenizedWhile() throws TokenizerException {
        final String test = "while";
        final Tokenizer testTokenizer = new Tokenizer(test.toCharArray());
        final List<Token> testList = testTokenizer.tokenize();
        Assertions.assertEquals(WhileToken.class, testList.get(0).getClass());
    }
    @Test
    public void checkCorrectTokenizedIdentifier() throws TokenizerException {
        final String test = "thisisanidentifier";
        final Tokenizer testTokenizer = new Tokenizer(test.toCharArray());
        final List<Token> testList = testTokenizer.tokenize();
        Assertions.assertEquals(IdentifierToken.class, testList.get(0).getClass());
    }
    @Test
    public void checkCorrectTokenizedOperator() throws TokenizerException {
        final String test = "+=-*/!%><&&||";
        final Tokenizer testTokenizer = new Tokenizer(test.toCharArray());
        final List<Token> testList = testTokenizer.tokenize();
        for (int i = 0; i < testList.size(); i++) {
            Assertions.assertEquals(OperatorToken.class, testList.get(i).getClass());
        }
    }
    @Test
    public void checkThrowsExceptions() {
        final String testString = " ";
        final Tokenizer testTokenizer = new Tokenizer(testString.toCharArray());
        final TokenizerException thrown =
                Assertions.assertThrows(TokenizerException.class,
                        testTokenizer::tokenize,
                        "Expected List of tokens");
    }
}
