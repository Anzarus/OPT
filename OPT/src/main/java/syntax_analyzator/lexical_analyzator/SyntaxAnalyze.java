package syntax_analyzator.lexical_analyzator;

import info_tables.DataTables;
import lexical_analyzator.LexemPlace;

import java.util.ArrayList;

public class SyntaxAnalyze {
    public static boolean syntaxAnalyze(ArrayList<Operation> grammar,
                                        DataTables data) {
        System.out.println();
        ArrayList<LexemPlace> arrayOfSyntaxError = getArrayOfSyntaxErrors(grammar, data);
        if (arrayOfSyntaxError.isEmpty()) {
            System.out.println("\nSyntax is alright");
            return true;
        } else {
            System.out.println("\nSyntax is not alright");
            return false;
        }
    }

    private static ArrayList<LexemPlace> getArrayOfSyntaxErrors(ArrayList<Operation> grammar, DataTables data) {
        Counter counter = new Counter(0, 0);
        ArrayList<LexemPlace> arrayOfErrors = new ArrayList<LexemPlace>();
        boolean firstErrorHasFound = false;
        if (!grammar.isEmpty()) {
            while (counter.lexemCounter < data.getArrayOfLexems().size() && !firstErrorHasFound) {
                if (Question.TRUE != recursiveFuncForKnutTable(grammar, grammar.get(0),
                        data, data.getArrayOfLexems().get(counter.getLexemCounter()),
                        arrayOfErrors, counter)) {
                    firstErrorHasFound = true;
                    printErrors(arrayOfErrors);
                }
                counter.tabCounter = 0;
                System.out.println("\n\n");
            }
        } else {
            System.out.println("Grammar is empty");
        }
        return arrayOfErrors;
    }


    private static Question recursiveFuncForKnutTable(ArrayList<Operation> grammar, Operation operation,
                                                      DataTables data, LexemPlace lexem,
                                                      ArrayList<LexemPlace> arrayOfErrors, Counter counter) {
        switch (operation.getTypeOfQuestion()) {
            case ADDRESS:
                System.out.println(tabulation(counter.getTabCounter()) + operation.getName());
                counter.iterateTabCounter();
                if (recursiveFuncForKnutTable(grammar, grammar.get(operation.getQuestionAddress()),
                        data, data.getArrayOfLexems().get(counter.getLexemCounter()),
                        arrayOfErrors, counter) == Question.TRUE) {
                    if (operation.getTypeOfTrueCase() == Question.ADDRESS) {
                        return recursiveFuncForKnutTable(grammar, grammar.get(operation.getTrueCaseAddress()), data,
                                data.getArrayOfLexems().get(counter.getLexemCounter()), arrayOfErrors, counter);
                    } else {
                        counter.decrementTabCounter();
                        return Question.TRUE;
                    }
                } else {
                    if (operation.getTypeOfFalseCase() == Question.ADDRESS) {
                        System.out.println(tabulation(counter.getTabCounter()) + "\tfalse");
                        return recursiveFuncForKnutTable(grammar, grammar.get(operation.getFalseCaseAddress()), data,
                                data.getArrayOfLexems().get(counter.getLexemCounter()), arrayOfErrors, counter);
                    } else {
                        System.out.println(tabulation(counter.getTabCounter()) + "\tfalse");
                        counter.decrementTabCounter();
                        return Question.FALSE;
                    }
                }
            case LEXEMS:
                System.out.println(tabulation(counter.getTabCounter()) +
                        lexem.getId() + " " +
                        operation.getName());
                if (isWrightLexem(data, operation.getQuestionLexem(), lexem.getId())) {
                    counter.iterateLexemCounter();
                    if (operation.getTypeOfTrueCase() == Question.ADDRESS) {
                        return recursiveFuncForKnutTable(grammar, grammar.get(operation.getTrueCaseAddress()), data,
                                data.getArrayOfLexems().get(counter.getLexemCounter()), arrayOfErrors, counter);
                    } else {
                        counter.decrementTabCounter();
                        return Question.TRUE;
                    }
                } else {
                    if (operation.getTypeOfFalseCase() == Question.ADDRESS) {
                        System.out.println(tabulation(counter.getTabCounter()) + "\tfalse");
                        return recursiveFuncForKnutTable(grammar, grammar.get(operation.getFalseCaseAddress()), data,
                                data.getArrayOfLexems().get(counter.getLexemCounter()), arrayOfErrors, counter);
                    } else {
                        arrayOfErrors.add(lexem);
                        System.out.println(tabulation(counter.getTabCounter()) + "\tfalse");
                        counter.decrementTabCounter();
                        return Question.FALSE;
                    }
                }
            case IS_DIGIT:
                if (operation.getQuestionAddress() < lexem.getId()) {
                    System.out.println(tabulation(counter.getTabCounter()) +
                            lexem.getId() + " " +
                            data.getTableOfConstants().get(lexem.getId() % 100 - 1).getLexem());
                    counter.iterateLexemCounter();
                    counter.decrementTabCounter();
                    return Question.TRUE;
                } else {
                    arrayOfErrors.add(lexem);
                    System.out.println(tabulation(counter.getTabCounter()) + "\tfalse");
                    counter.decrementTabCounter();
                    return Question.FALSE;
                }
            case IS_IDENTIFIER:
                if (operation.getQuestionAddress() < lexem.getId()) {
                    System.out.println(tabulation(counter.getTabCounter()) +
                            lexem.getId() + " " +
                            data.getTableOfIdentifier().get(lexem.getId() % 100 - 1).getLexem());
                    counter.iterateLexemCounter();
                    counter.decrementTabCounter();
                    return Question.TRUE;
                } else {
                    arrayOfErrors.add(lexem);
                    System.out.println(tabulation(counter.getTabCounter()) + "\tfalse");
                    counter.decrementTabCounter();
                    return Question.FALSE;
                }
            case EMPTY:
                System.out.println(tabulation(counter.getTabCounter()) + operation.getName());
                counter.decrementTabCounter();
                return Question.TRUE;
            case ERROR:
                System.out.println(tabulation(counter.getTabCounter()) + operation.getName());
                counter.decrementTabCounter();
                return Question.ERROR;
        }
        return Question.FALSE;
    }

    public static void printSyntax(ArrayList<Operation> arrayList) {
        Operation tmp;
        for (int i = 0; i < arrayList.size(); i++) {
            tmp = arrayList.get(i);
            switch (arrayList.get(i).getTypeOfQuestion()) {
                case LEXEMS:
                    System.out.println(i + "\t" + tmp.getTypeOfQuestion().toString() + " " + tmp.getQuestionLexem() +
                            "|" + tmp.getTypeOfTrueCase() + " " + tmp.getTrueCaseAddress() +
                            "|" + tmp.getTypeOfFalseCase() + " " + tmp.getFalseCaseAddress());
                    break;
                case ADDRESS:
                    System.out.println(i + "\t" + tmp.getTypeOfQuestion().toString() + " " + tmp.getQuestionAddress() +
                            "|" + tmp.getTypeOfTrueCase() + " " + tmp.getTrueCaseAddress() +
                            "|" + tmp.getTypeOfFalseCase() + " " + tmp.getFalseCaseAddress());
                    break;
                case EMPTY:
                    System.out.println(i + "\t" + tmp.getTypeOfQuestion().toString() +
                            "|" + tmp.getTypeOfTrueCase() +
                            "|" + tmp.getTypeOfFalseCase());
                    break;
                case IS_DIGIT:
                    System.out.println(i + "\t" + tmp.getTypeOfQuestion().toString() +
                            "|>" + tmp.getQuestionAddress() + "|" + tmp.getTypeOfTrueCase() +
                            "|" + tmp.getTypeOfFalseCase());
                    break;
                case IS_IDENTIFIER:
                    System.out.println(i + "\t" + tmp.getTypeOfQuestion().toString() +
                            "|>" + tmp.getQuestionAddress() + "|" + tmp.getTypeOfTrueCase() +
                            "|" + tmp.getTypeOfFalseCase());
                    break;
                default:
                    break;
            }
        }
    }

    private static void printErrors(ArrayList<LexemPlace> arrayOfErrors) {
        int counter = 0;
        while (counter < arrayOfErrors.size()) {
            System.out.println("Error in line " + arrayOfErrors.get(counter).getString()
                    + " on place " + arrayOfErrors.get(counter).getPlace());
            counter++;
        }
    }

    private static boolean isWrightLexem(DataTables data, String questionLexem, int lexemId) {
        String str = findLexem(lexemId, data);
        return questionLexem.equals(str);
    }

    private static String findLexem(int lexemId, DataTables data) {
        if (lexemId > 400 && lexemId < 500) {
            return data.getTableOfKeyWords().get(lexemId % 100 - 1).getLexem();
        }
        if (lexemId < 128) {
            if (data.getTableOfSymbols()[lexemId] != 6) return String.valueOf((char) lexemId);
        }
        return "";
    }

    private static String tabulation(int counter) {
        StringBuilder tab = new StringBuilder();
        for (int i = 0; i < counter; i++) {
            tab.append("\t");
        }
        return tab.toString();
    }

    private static class Counter {
        private int lexemCounter;
        private int tabCounter;

        Counter(int lexemCounter, int tabCounter) {
            this.lexemCounter = lexemCounter;
            this.tabCounter = tabCounter;
        }

        int getLexemCounter() {
            return lexemCounter;
        }

        void iterateLexemCounter() {
            this.lexemCounter++;
        }

        int getTabCounter() {
            return tabCounter;
        }

        void iterateTabCounter() {
            this.tabCounter++;
        }

        void decrementTabCounter() {
            this.tabCounter--;
        }
    }
}
