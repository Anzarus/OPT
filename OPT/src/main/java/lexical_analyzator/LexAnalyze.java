package lexical_analyzator;

import info_tables.DataTables;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static starter.Main.searchInInfoTable;

public class LexAnalyze {

    public static void lexicalAnalise(DataTables data) {
        try {
            FileReader fileReader = new FileReader("C:\\Users\\Admin\\IdeaProjects\\OPT\\OPT\\src\\main\\resources\\TEST1");
            int[] counter = {1, 1};

            int ch = fileReader.read();

            do {
                ch = analyzeFunc(data, fileReader, counter, ch);
            } while (ch != -1);

            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int analyzeFunc(DataTables data, FileReader fileReader, int[] counter, int ch) throws IOException {
        String str = "";

        switch (data.getTableOfSymbols()[ch]) {
            case 0:
                whiteSpaceSymbolCase(counter, ch);
                ch = fileReader.read();
                break;
            case 1:
                boolean isFoundLetter = false;
                do {
                    str += (char) ch;
                    ch = fileReader.read();
                    if (ch != -1 && data.getTableOfSymbols()[ch] == 2) isFoundLetter = true;
                } while (ch != -1 && data.getTableOfSymbols()[ch] == 1);

                if (isFoundLetter) {
                    ch = notValidIdentifier(data, fileReader, counter, ch, str);
                    break;
                }

                int index = searchInInfoTable(str, data.getTableOfConstants());
                if (index == -1) {
                    data.getTableOfConstants().add(new LexemId(str,
                            data.getTableOfCounters()[2] + data.getTableOfConstants().size() + 1));
                    data.getArrayOfLexems().add(new LexemPlace(data.getTableOfCounters()[2] +
                            data.getTableOfConstants().size(), counter[0], counter[1]));
                } else {
                    data.getArrayOfLexems().add(new LexemPlace(data.getTableOfConstants().get(index).getId(),
                            counter[0], counter[1]));
                }
                counter[1]++;
                break;
            case 2:
                do {
                    str += (char) ch;
                    ch = fileReader.read();
                } while (ch != -1 && (data.getTableOfSymbols()[ch] == 1 || data.getTableOfSymbols()[ch] == 2));

                isKeyWord(data, counter, str);
                counter[1]++;
                break;
            case 3:
                dividersCase(data, counter, ch, str);
                ch = fileReader.read();
                break;
            case 4:
                ch = fileReader.read();
                break;
            case 5:
                str += (char) ch;
                ch = fileReader.read();
                str += (char) ch;
                if (str.equals("(*")) {
                    ch = commentContext(fileReader, counter, str);
                } else {
                    dividersCase(data, counter, (int) str.charAt(0), "");
                }
                break;
            case 6:
                System.out.println("Not supported symbol " + (char) ch + " in line " + counter[0] +
                        " in place " + counter[1]);
                counter[1]++;
                ch = fileReader.read();
                break;
            default:
                ch = fileReader.read();
        }
        return ch;
    }

    private static boolean isKeyWord(DataTables data, int[] counter, String str) {
        int index;
        index = searchInInfoTable(str, data.getTableOfKeyWords());
        if (index != -1) {
            data.getArrayOfLexems().add(new LexemPlace(data.getTableOfKeyWords().get(index).getId(),
                    counter[0], counter[1]));
            return true;
        }

        index = searchInInfoTable(str, data.getTableOfIdentifier());
        if (index == -1) {
            data.getTableOfIdentifier().add(new LexemId(str,
                    data.getTableOfCounters()[1] + data.getTableOfIdentifier().size() + 1));
            data.getArrayOfLexems().add(new LexemPlace(data.getTableOfCounters()[1] +
                    data.getTableOfIdentifier().size(), counter[0], counter[1]));
        } else {
            data.getArrayOfLexems().add(new LexemPlace(data.getTableOfIdentifier().get(index).getId(),
                    counter[0], counter[1]));
        }
        return false;
    }

    private static int commentContext(FileReader fileReader, int[] counter, String str) throws IOException {
        int ch;
        str = str.substring(1);
        ch = fileReader.read();
        str += (char) ch;
        do {
            str = str.substring(1);
            if (ch == 10) {
                counter[0]++;
                counter[1] = 1;
            }
            ch = fileReader.read();
            str += (char) ch;
            if (ch == -1) {
                System.out.println("File unexpected ends");
                break;
            }
        } while (!str.equals("*)"));
        if (ch != -1) ch = fileReader.read();
        return ch;
    }

    private static void dividersCase(DataTables data, int[] counter, int ch, String str) {
        int index;
        str += (char) ch;
        index = searchInInfoTable(str, data.getTableOfDividers());
        if (index == -1) {
            data.getTableOfDividers().add(new LexemId(str, ch));
            data.getArrayOfLexems().add(new LexemPlace(ch, counter[0], counter[1]));
        } else {
            data.getArrayOfLexems().add(new LexemPlace(ch, counter[0], counter[1]));
        }
        counter[1]++;
    }

    private static int notValidIdentifier(DataTables data, FileReader fileReader, int[] counter, int ch, String str) throws IOException {
        while (ch != -1 && (data.getTableOfSymbols()[ch] == 1 || data.getTableOfSymbols()[ch] == 2)) {
            str += (char) ch;
            ch = fileReader.read();
        }
        System.out.println("Not supported context with " + str + " in line " + counter[0] +
                " in place " + counter[1]);
        counter[1]++;
        return ch;
    }

    private static void whiteSpaceSymbolCase(int[] counter, int ch) {
        counter[1]++;
        if (ch == 10) {
            counter[0]++;
            counter[1] = 1;
        }
    }
}