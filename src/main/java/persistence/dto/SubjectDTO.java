package persistence.dto;

public class SubjectDTO {
    private int id;
    private String subjectName;
    private int targetGrade;
    private int semester;
    private int credit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getTargetGrade() {
        return targetGrade;
    }

    public void setTargetGrade(int targetGrade) {
        this.targetGrade = targetGrade;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "SubjectDTO{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                ", targetGrade=" + targetGrade +
                ", semester=" + semester +
                ", credit=" + credit +
                '}';
    }
}
