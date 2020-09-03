package exam.examinationContext.userInterface.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExaminationRequest {
    private String name;
    private List<String> studentIds;
    private List<String> teacherIds;
    private String answerSheetId;
    private String paperId;
}
