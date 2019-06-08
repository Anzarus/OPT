package lexical_analyzator;

public class LexemId {
    private String lexem;
    private int id;

    public LexemId(String lexem, int id){
        this.lexem = lexem;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public String getLexem() {
        return lexem;
    }
}