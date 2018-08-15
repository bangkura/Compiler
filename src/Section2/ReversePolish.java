/**
 * @author: Bangkura
 * @create: 2018-08-15 15:27
 **/

package Section2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ReversePolish {
    private static String[] expr;
    private static int index;
    public static void main(String... args) throws Exception{
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a arithmetic expression separated by space like \" 1 + 2 - 3\": ");

        String str = scanner.readLine();

        expr = str.split(" ");
        parse(expr);
    }

    private static void parse(String[] expr) throws Exception{
        index = 0;
        term();
        rest();
    }


    private static void rest() throws Exception{
        for(;;) {
            if(index == expr.length)
                return;
            switch(expr[index]) {
                case "+" :
                    match("+");
                    term();
                    System.out.print(" + ");
                    rest();
                    continue;
                case "-" :
                    match("-");
                    term();
                    System.out.print(" - ");
                    rest();
                    continue;
                default:
                    break;
            }
        }
    }

    private static void match(String terminal) throws Exception{
        if(terminal.equals(expr[index]))
            index++;
        else
            throw new Exception("Wrong syntax");
    }

    private static void term() throws Exception{
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");

        if(pattern.matcher(expr[index]).matches()) {
            System.out.print(" " + expr[index] + " ");
            index++;
        }
        else
            throw new Exception("Wrong syntax");
    }
}
