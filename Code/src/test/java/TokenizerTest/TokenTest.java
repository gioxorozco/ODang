package TokenizerTest;

import Tokenizer.*;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.*;

public class TokenTest {

    @Test
    public void checkCorrectTokenizedInteger() throws TokenizerException {
        String testInt = "1234";
        Tokenizer testTokenizer = new Tokenizer(testInt.toCharArray());
        List<Token> testList = testTokenizer.tokenize();
        Assertions.assertEquals(IntegerToken.class, testList.get(0).getClass());
    }

    @Test
    public void checkThrowsExceptions() {
        String testString = " ";
        Tokenizer testTokenizer = new Tokenizer(testString.toCharArray());
        TokenizerException thrown =
                Assertions.assertThrows(TokenizerException.class,
                        testTokenizer::tokenize,
                        "Expected List of tokens");
    }
}
