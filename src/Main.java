import tree.EvaluateAST;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) {
        DemoRepParse parse = new DemoRepParse();
        try {
            String toParse = "(30 + 20 * 3) / (5 * 9)";

            System.out.println(toParse);
            System.out.println("\n");
            System.out.println(parse.parse(toParse));
            System.out.println("\n");
            System.out.println("Recus: " + EvaluateAST.eval(parse.parse(toParse)));
//            System.out.println("\n");
//            System.out.println("Stack: " + EvaluateAST.evalStack(parse.parse(toParse)));

        } catch (ParseException e) {
            e.printStackTrace();
        }


//        DemoRepParse parser = new DemoRepParse();
//
//        try {
//            System.out.println(parser.parse(""));
//            System.out.println(parser.parse("0"));
//            System.out.println(parser.parse("0x0"));
//            System.out.println(parser.parse("0b0") + "\n\n");
//            System.out.println(parser.parse("-10") + "\n\n");
//            System.out.println(parser.parse("-0x10") + "\n\n");
//            System.out.println(parser.parse("10 + 12") + "\n\n");
//            System.out.println(parser.parse("10 * 15 - (12 * 4)") + "\n\n");
//            System.out.println(parser.parse("10 * 15 - (0x12 * 4)") + "\n\n");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }

}
