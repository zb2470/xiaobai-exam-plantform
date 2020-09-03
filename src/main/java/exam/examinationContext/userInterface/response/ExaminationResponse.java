package exam.examinationContext.userInterface.response;

import exam.examinationContext.domain.model.examination.Examination;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExaminationResponse {
    private String id;
    private String name;
    private List<String> studentIds;
    private List<String> teacherIds;
    private String answerSheetId;
    private String paperId;

    public static ExaminationResponse toExaminationResponse(Examination examination) {
        return ExaminationResponse.builder().build();
    }
}
