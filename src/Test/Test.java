/**
 * @author: Bangkura
 * @create: 2018-08-15 17:57
 **/

package Test;

import lexer.Lexer;
import lexer.Token;

import java.io.IOException;

public class Test {
    public static void main(String... args) throws IOException {
        Lexer lexer = new Lexer();

        Token token = lexer.scan();
        System.out.print("end");
    }
}
