package app.ntnt.finalprojectexamonline.model.entites;

public class Subject {
    private Long subjectId;
    private String name;
    private String image;

    public Subject(Long subjectId, String name, String image) {
        this.subjectId = subjectId;
        this.name = name;
        this.image = image;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
