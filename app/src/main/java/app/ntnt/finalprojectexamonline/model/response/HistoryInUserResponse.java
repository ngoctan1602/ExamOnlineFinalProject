package app.ntnt.finalprojectexamonline.model.response;

public class HistoryInUserResponse {
    private Long hisId;
    private Long userId;
    private Long testId;
    private Float score;
    private String time;

    public HistoryInUserResponse(Long hisId, Long userId, Long testId, Float score, String time) {
        this.hisId = hisId;
        this.userId = userId;
        this.testId = testId;
        this.score = score;
        this.time = time;
    }

    public HistoryInUserResponse() {
    }

    public Long getHisId() {
        return hisId;
    }

    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
