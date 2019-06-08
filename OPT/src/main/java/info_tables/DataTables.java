package info_tables;

import lexical_analyzator.LexemId;
import lexical_analyzator.LexemPlace;

import java.util.ArrayList;

public class DataTables {
    private ArrayList<LexemId> tableOfKeyWords;
    private ArrayList<LexemId> tableOfIdentifier;
    private ArrayList<LexemId> tableOfConstants;
    private ArrayList<LexemId> tableOfDividers;
    private int[] tableOfSymbols;
    private int[] tableOfCounters = {400, 1000, 500};

    private ArrayList<LexemPlace> arrayOfLexems;

    public DataTables(ArrayList<LexemId> tableOfKeyWords,
                      ArrayList<LexemId> tableOfIdentifier,
                      ArrayList<LexemId> tableOfConstants,
                      ArrayList<LexemId> tableOfDividers,
                      int[] tableOfSymbols) {
        this.tableOfKeyWords = tableOfKeyWords;
        this.tableOfIdentifier = tableOfIdentifier;
        this.tableOfConstants = tableOfConstants;
        this.tableOfDividers = tableOfDividers;
        this.tableOfSymbols = tableOfSymbols;
        this.arrayOfLexems = new ArrayList<LexemPlace>();
    }

    public ArrayList<LexemId> getTableOfConstants() {
        return tableOfConstants;
    }

    public ArrayList<LexemId> getTableOfDividers() {
        return tableOfDividers;
    }

    public ArrayList<LexemId> getTableOfIdentifier() {
        return tableOfIdentifier;
    }

    public ArrayList<LexemId> getTableOfKeyWords() {
        return tableOfKeyWords;
    }

    public int[] getTableOfCounters() {
        return tableOfCounters;
    }

    public int[] getTableOfSymbols() {
        return tableOfSymbols;
    }

    public void setArrayOfLexems(ArrayList<LexemPlace> arrayOfLexems) {
        this.arrayOfLexems = arrayOfLexems;
    }

    public ArrayList<LexemPlace> getArrayOfLexems() {
        return arrayOfLexems;
    }
}
