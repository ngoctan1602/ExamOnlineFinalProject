package app.ntnt.finalprojectexamonline.model.response;

import java.util.List;

import app.ntnt.finalprojectexamonline.model.entites.Answer;

public class QuestionResponse {
    Long questionId;
    String question;
    String image;
    List<AnswerResponse> answers;

    public QuestionResponse(Long questionId, String question, String image, List<AnswerResponse> answers) {
        this.questionId = questionId;
        this.question = question;
        this.image = image;
        this.answers = answers;
    }

    public QuestionResponse() {
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<AnswerResponse> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerResponse> answers) {
        this.answers = answers;
    }
}
