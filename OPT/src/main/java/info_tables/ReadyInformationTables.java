package info_tables;

import lexical_analyzator.LexemId;

import java.util.ArrayList;

public class ReadyInformationTables {
    public static int[] setTableOfAsciiAndSymbolCategories() {
        int[] symbolCategories = new int[128];

        for (int i = 0; i < 128; i++) {
            symbolCategories[i] = 6;    //unsupported symbol
        }

        for (int i = 9; i < 14; i++) {
            symbolCategories[i] = 0;    //space symbols
        }
        symbolCategories[32] = 0;       //space symbols

        for (int i = 48; i < 58; i++) {
            symbolCategories[i] = 1;    //symbols that constant variables start with
        }
        for (int i = 65; i < 91; i++) {
            symbolCategories[i] = 2;    //symbols that identifiers and keywords variables start with
        }
        symbolCategories[41] = 3;    //one symbol divider )
        symbolCategories[44] = 3;    //one symbol divider ,
        symbolCategories[46] = 3;    //one symbol divider .
        symbolCategories[58] = 3;    //one symbol divider ;
        symbolCategories[59] = 3;    //one symbol divider ;

        symbolCategories[40] = 5;    //symbols that comments start with

        return symbolCategories;
    }

    public static ArrayList<LexemId> setTableOfKeyWords() {
        ArrayList<LexemId> keyWordsArray = new ArrayList<LexemId>();
        keyWordsArray.add(new LexemId("PROGRAM", 401));
        keyWordsArray.add(new LexemId("PROCEDURE", 402));
        keyWordsArray.add(new LexemId("BEGIN", 403));
        keyWordsArray.add(new LexemId("END", 404));
        keyWordsArray.add(new LexemId("LABEL", 405));
        return keyWordsArray;
    }

    public static ArrayList<LexemId> setTableOfDividers() {
        return new ArrayList<LexemId>();
    }

    public static ArrayList<LexemId> setTableOfConstants() {
        return new ArrayList<LexemId>();
    }

    public static ArrayList<LexemId> setTableOfIdentifier() {
        return new ArrayList<LexemId>();
    }
}