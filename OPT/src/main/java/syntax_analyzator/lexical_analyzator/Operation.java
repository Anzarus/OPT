package syntax_analyzator.lexical_analyzator;

public class Operation {
    final private Question typeOfQuestion;
    final private Question typeOfTrueCase;
    final private Question typeOfFalseCase;
    final private String name;

    private int questionAddress = -1;
    private int trueCaseAddress = -1;
    private int falseCaseAddress = -1;
    private String questionLexem = "";

    Operation(Question typeOfQuestion, Question typeOfTrueCase, Question typeOfFalseCase, String name) {
        this.typeOfQuestion = typeOfQuestion;
        this.typeOfTrueCase = typeOfTrueCase;
        this.typeOfFalseCase = typeOfFalseCase;
        this.name = name;
    }

    Operation(Question typeOfQuestion, int questionAddress, Question typeOfTrueCase,
              Question typeOfFalseCase, String name) {
        this.typeOfQuestion = typeOfQuestion;
        this.typeOfTrueCase = typeOfTrueCase;
        this.typeOfFalseCase = typeOfFalseCase;
        this.questionAddress = questionAddress;
        this.name = name;
    }

    Operation(Question typeOfQuestion, int questionAddress, Question typeOfTrueCase,
              int trueCaseAddress, Question typeOfFalseCase, String name) {
        this.typeOfQuestion = typeOfQuestion;
        this.typeOfTrueCase = typeOfTrueCase;
        this.typeOfFalseCase = typeOfFalseCase;
        this.questionAddress = questionAddress;
        this.trueCaseAddress = trueCaseAddress;
        this.name = name;
    }

    Operation(Question typeOfQuestion, int questionAddress, Question typeOfTrueCase,
              Question typeOfFalseCase, int falseCaseAddress, String name) {
        this.typeOfQuestion = typeOfQuestion;
        this.typeOfTrueCase = typeOfTrueCase;
        this.typeOfFalseCase = typeOfFalseCase;
        this.questionAddress = questionAddress;
        this.falseCaseAddress = falseCaseAddress;
        this.name = name;
    }

    Operation(Question typeOfQuestion, int questionAddress, Question typeOfTrueCase,
              int trueCaseAddress, Question typeOfFalseCase, int falseCaseAddress, String name) {
        this.typeOfQuestion = typeOfQuestion;
        this.typeOfTrueCase = typeOfTrueCase;
        this.typeOfFalseCase = typeOfFalseCase;
        this.questionAddress = questionAddress;
        this.trueCaseAddress = trueCaseAddress;
        this.falseCaseAddress = falseCaseAddress;
        this.name = name;
    }

    Operation(Question typeOfQuestion, String questionLexem, Question typeOfTrueCase,
              Question typeOfFalseCase, String name) {
        this.typeOfQuestion = typeOfQuestion;
        this.typeOfTrueCase = typeOfTrueCase;
        this.typeOfFalseCase = typeOfFalseCase;
        this.questionLexem = questionLexem;
        this.name = name;
    }

    Operation(Question typeOfQuestion, String questionLexem, Question typeOfTrueCase,
              int trueCaseAddress, Question typeOfFalseCase, String name) {
        this.typeOfQuestion = typeOfQuestion;
        this.typeOfTrueCase = typeOfTrueCase;
        this.typeOfFalseCase = typeOfFalseCase;
        this.questionLexem = questionLexem;
        this.trueCaseAddress = trueCaseAddress;
        this.name = name;
    }

    Operation(Question typeOfQuestion, String questionLexem, Question typeOfTrueCase,
              Question typeOfFalseCase, int falseCaseAddress, String name) {
        this.typeOfQuestion = typeOfQuestion;
        this.typeOfTrueCase = typeOfTrueCase;
        this.typeOfFalseCase = typeOfFalseCase;
        this.questionLexem = questionLexem;
        this.falseCaseAddress = falseCaseAddress;
        this.name = name;
    }

    Operation(Question typeOfQuestion, String questionLexem, Question typeOfTrueCase,
              int trueCaseAddress, Question typeOfFalseCase, int falseCaseAddress, String name) {
        this.typeOfQuestion = typeOfQuestion;
        this.typeOfTrueCase = typeOfTrueCase;
        this.typeOfFalseCase = typeOfFalseCase;
        this.questionLexem = questionLexem;
        this.trueCaseAddress = trueCaseAddress;
        this.falseCaseAddress = falseCaseAddress;
        this.name = name;
    }

    Question getTypeOfQuestion() {
        return typeOfQuestion;
    }

    Question getTypeOfTrueCase() {
        return typeOfTrueCase;
    }

    Question getTypeOfFalseCase() {
        return typeOfFalseCase;
    }

    int getQuestionAddress() {
        return questionAddress;
    }

    int getTrueCaseAddress() {
        return trueCaseAddress;
    }

    int getFalseCaseAddress() {
        return falseCaseAddress;
    }

    String getQuestionLexem() {
        return questionLexem;
    }

    String getName() {
        return name;
    }
}
