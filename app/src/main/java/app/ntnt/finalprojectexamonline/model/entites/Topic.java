package app.ntnt.finalprojectexamonline.model.entites;

public class Topic {
    private int id;
    private String name;
    // Số bài thi, số câu hỏi
    private int sumQuestion;
    private int sumTest;

    public Topic(int id, String name, int sumQuestion, int sumTest) {
        this.id = id;
        this.name = name;
        this.sumQuestion = sumQuestion;
        this.sumTest = sumTest;
    }

    public Topic() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSumQuestion() {
        return sumQuestion;
    }

    public void setSumQuestion(int sumQuestion) {
        this.sumQuestion = sumQuestion;
    }

    public int getSumTest() {
        return sumTest;
    }

    public void setSumTest(int sumTest) {
        this.sumTest = sumTest;
    }
}
