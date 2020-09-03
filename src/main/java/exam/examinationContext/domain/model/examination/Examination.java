package exam.examinationContext.domain.model.examination;

import exam.examinationContext.shared.Entity;

import java.util.List;

public class Examination implements Entity<Examination> {
    private ExaminationId examinationId;
    private List<String> studentIds;
    private List<String> teacherIds;
    private String answerSheetId;
    private String paperId;

    public Examination(ExaminationId examinationId, List<String> studentIds, List<String> teacherIds, String answerSheetId, String paperId) {
        this.examinationId = examinationId;
        this.studentIds = studentIds;
        this.teacherIds = teacherIds;
        this.answerSheetId = answerSheetId;
        this.paperId = paperId;
    }

    public static Examination assemble(ExaminationId examinationId, List<String> studentIds, List<String> teacherIds, String answerSheetId, String paperId) {
        return new Examination(examinationId, studentIds, teacherIds, answerSheetId, paperId);
    }

    public ExaminationId getExaminationId() {
        return examinationId;
    }

    public List<String> getStudentIds() {
        return studentIds;
    }

    public List<String> getTeacherIds() {
        return teacherIds;
    }

    public String getAnswerSheetId() {
        return answerSheetId;
    }

    public String getPaperId() {
        return paperId;
    }

    @Override
    public boolean sameIdentityAs(Examination other) {
        return examinationId.sameValueAs(other.getExaminationId());
    }

    public Examination reassemble(List<String> studentIds, List<String> teacherIds, String answerSheetId, String paperId) {
        this.studentIds = studentIds;
        this.teacherIds = teacherIds;
        this.answerSheetId = answerSheetId;
        this.paperId = paperId;
        return this;
    }
}
