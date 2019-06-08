package lexical_analyzator;

public class LexemPlace {
    private int id;
    private int string;
    private int place;

    LexemPlace(int id, int string, int place) {
        this.id = id;
        this.string = string;
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public int getString() {
        return string;
    }

    public int getPlace() {
        return place;
    }
}
