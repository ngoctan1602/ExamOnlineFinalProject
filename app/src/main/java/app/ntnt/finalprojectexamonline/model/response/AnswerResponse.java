package app.ntnt.finalprojectexamonline.model.response;

public class AnswerResponse {
    Long answerId;
    String content;

    public AnswerResponse(Long answerId, String content) {
        this.answerId = answerId;
        this.content = content;
    }

    public AnswerResponse() {
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
