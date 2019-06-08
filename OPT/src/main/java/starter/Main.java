package starter;

import code_generator.CodeGenerator;
import info_tables.DataTables;
import info_tables.ReadyInformationTables;
import lexical_analyzator.*;
import syntax_analyzator.lexical_analyzator.Grammar;
import syntax_analyzator.lexical_analyzator.Operation;
import syntax_analyzator.lexical_analyzator.SyntaxAnalyze;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;

public class Main {
    public static void main(String[] args) {
        DataTables data = new DataTables(ReadyInformationTables.setTableOfKeyWords(),
                ReadyInformationTables.setTableOfIdentifier(),
                ReadyInformationTables.setTableOfConstants(),
                ReadyInformationTables.setTableOfDividers(),
                ReadyInformationTables.setTableOfAsciiAndSymbolCategories());

        LexAnalyze.lexicalAnalise(data);

        printArrOfLexems(data.getArrayOfLexems());
        printInfoTables(data.getTableOfConstants());
        printInfoTables(data.getTableOfIdentifier());
        printInfoTables(data.getTableOfDividers());
        printInfoTables(data.getTableOfKeyWords());

        ArrayList<Operation> gram = Grammar.setGrammar();
//        SyntaxAnalyze.printSyntax(gram);

        if(SyntaxAnalyze.syntaxAnalyze(gram, data)){
            CodeGenerator.CodeGenerator();
        }
    }

    public static int searchInInfoTable(String str, ArrayList<LexemId> tableOfCounters) {
        int counter = 0;
        while (counter < tableOfCounters.size()) {
            if (str.equals(tableOfCounters.get(counter).getLexem())) return counter;
            counter++;
        }
        return -1;
    }

    private static void printInfoTables(ArrayList<LexemId> arrayList) {
        int count = 0;
        System.out.printf("\n|%4s|%20s|\n", "code", "name");
        while (arrayList.size() > count) {
            System.out.printf("|%4d|%20s|\n", arrayList.get(count).getId(),
                    arrayList.get(count).getLexem());
            count++;
        }
        System.out.print("\n\n");
    }

    private static void printArrOfLexems(ArrayList<LexemPlace> arrayList) {
        int count = 0;
        System.out.printf("\n|%4s |%4s |%4s |\n", "code", "str", "pos");
        while (arrayList.size() > count) {
            System.out.printf("|%4d |%4d |%4d |\n", arrayList.get(count).getId(),
                    arrayList.get(count).getString(), arrayList.get(count).getPlace());
            count++;
        }
        System.out.print("\n\n");
    }
}