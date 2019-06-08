package syntax_analyzator.lexical_analyzator;

import java.util.ArrayList;

public class Grammar {
    public static ArrayList<Operation> setGrammar() {
        ArrayList<Operation> machineOfKnut = new ArrayList<Operation>();

        //1
        machineOfKnut.add(new Operation(Question.ADDRESS, 1, Question.TRUE, Question.ERROR, "<Program>"));
        //2
        machineOfKnut.add(new Operation(Question.LEXEMS, "PROGRAM", Question.ADDRESS, 2, Question.ADDRESS, 6, "PROGRAM"));
        machineOfKnut.add(new Operation(Question.ADDRESS, 32, Question.ADDRESS, 3, Question.FALSE, "<procedure-identifier>"));
        machineOfKnut.add(new Operation(Question.LEXEMS, ";", Question.ADDRESS, 4, Question.FALSE, ";"));
        machineOfKnut.add(new Operation(Question.ADDRESS, 12, Question.ADDRESS, 5, Question.FALSE, "<block>"));
        machineOfKnut.add(new Operation(Question.LEXEMS, ".", Question.TRUE, Question.FALSE, "."));
        machineOfKnut.add(new Operation(Question.LEXEMS, "PROCEDURE", Question.ADDRESS, 7, Question.FALSE, "PROCEDURE"));
        machineOfKnut.add(new Operation(Question.ADDRESS, 32, Question.ADDRESS, 8, Question.FALSE, "<procedure-identifier>"));
        machineOfKnut.add(new Operation(Question.ADDRESS, 26, Question.ADDRESS, 9, Question.FALSE, "<parameters-list>"));
        machineOfKnut.add(new Operation(Question.LEXEMS, ";", Question.ADDRESS, 10, Question.FALSE, ";"));
        machineOfKnut.add(new Operation(Question.ADDRESS, 12, Question.ADDRESS, 11, Question.FALSE, "<block>"));
        machineOfKnut.add(new Operation(Question.LEXEMS, ";", Question.TRUE, Question.FALSE, ";"));
        //3
        machineOfKnut.add(new Operation(Question.ADDRESS, 16, Question.ADDRESS, 13, Question.FALSE, "<declarations>"));
        machineOfKnut.add(new Operation(Question.LEXEMS, "BEGIN", Question.ADDRESS, 14, Question.FALSE, "BEGIN"));
        machineOfKnut.add(new Operation(Question.ADDRESS, 31, Question.ADDRESS, 15, Question.FALSE, "<statement-list>"));
        machineOfKnut.add(new Operation(Question.LEXEMS, "END", Question.TRUE, Question.FALSE, "END"));
        //4
        machineOfKnut.add(new Operation(Question.ADDRESS, 17, Question.TRUE, Question.FALSE, "<label-declarations>"));
        //5
        machineOfKnut.add(new Operation(Question.LEXEMS, "LABEL", Question.ADDRESS, 18, Question.ADDRESS, 21, "LABEL"));
        machineOfKnut.add(new Operation(Question.ADDRESS, 34, Question.ADDRESS, 19, Question.FALSE, "<unsigned-integer>"));
        machineOfKnut.add(new Operation(Question.ADDRESS, 22, Question.ADDRESS, 20, Question.FALSE, "<labels-list>"));
        machineOfKnut.add(new Operation(Question.LEXEMS, ";", Question.TRUE, Question.FALSE, ";"));
        machineOfKnut.add(new Operation(Question.EMPTY, Question.TRUE, Question.TRUE, "<empty>"));
        //6
        machineOfKnut.add(new Operation(Question.LEXEMS, ",", Question.ADDRESS, 23, Question.ADDRESS, 25, ","));
        machineOfKnut.add(new Operation(Question.ADDRESS, 34, Question.ADDRESS, 24, Question.FALSE, "<unsigned-integer>"));
        machineOfKnut.add(new Operation(Question.ADDRESS, 22, Question.TRUE, Question.FALSE, "<labels-list>"));
        machineOfKnut.add(new Operation(Question.EMPTY, Question.TRUE, Question.TRUE, "<empty>"));
        //7
        machineOfKnut.add(new Operation(Question.LEXEMS, "(", Question.ADDRESS, 27, Question.ADDRESS, 29, "("));
        machineOfKnut.add(new Operation(Question.ADDRESS, 30, Question.ADDRESS, 28, Question.FALSE, "<declarations-list>"));
        machineOfKnut.add(new Operation(Question.LEXEMS, ")", Question.TRUE, Question.FALSE, ")"));
        machineOfKnut.add(new Operation(Question.EMPTY, Question.TRUE, Question.TRUE, "<empty>"));
        //8
 /*       machineOfKnut.add(new Operation(Question.ADDRESS, 37, Question.ADDRESS, 31, Question.ADDRESS, 32, "<declaration>"));
        machineOfKnut.add(new Operation(Question.ADDRESS, 30, Question.TRUE, Question.FALSE,"<declaration-list>"));
 */     machineOfKnut.add(new Operation(Question.EMPTY, Question.TRUE,Question.TRUE, "<empty>"));
        //9
        machineOfKnut.add(new Operation(Question.EMPTY, Question.TRUE, Question.TRUE, "<empty>"));
        //10
        machineOfKnut.add(new Operation(Question.ADDRESS, 33, Question.TRUE, Question.FALSE, "<identifier>"));
        //11
        machineOfKnut.add(new Operation(Question.IS_IDENTIFIER, 1000, Question.TRUE, Question.FALSE, "IsIdentifier"));
        //13
        machineOfKnut.add(new Operation(Question.IS_DIGIT, 500, Question.TRUE, Question.FALSE, "IsDigit"));
/*
        14
        machineOfKnut.add(new Operation(Question.ADDRESS, 35, Question.ADDRESS, 38, Question.FALSE, "<identifier>"));
        machineOfKnut.add(new Operation(Question.LEXEMS, ":", Question.ADDRESS,39, Question.FALSE, ":"));
        machineOfKnut.add(new Operation(Question.ADDRESS, 36, Question.ADDRESS, 40, Question.FALSE, "<unsigned-integer>"));
        machineOfKnut.add(new Operation(Question.LEXEMS, ";", Question.TRUE, Question.FALSE, ";"));
*/

        return machineOfKnut;
    }
}
