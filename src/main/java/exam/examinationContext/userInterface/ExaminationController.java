package exam.examinationContext.userInterface;

import exam.examinationContext.application.ExaminationApplication;
import exam.examinationContext.domain.model.examination.Examination;
import exam.examinationContext.userInterface.request.ExaminationRequest;
import exam.examinationContext.userInterface.response.ExaminationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExaminationController {
    private final ExaminationApplication examinationApplication;

    @Autowired
    public ExaminationController(ExaminationApplication examinationApplication) {
        this.examinationApplication = examinationApplication;
    }

    @PostMapping("/examination")
    public ExaminationResponse assemble(ExaminationRequest examinationRequest) {
        Examination examination = examinationApplication.assemblePaper(examinationRequest);
        return ExaminationResponse.toExaminationResponse(examination);
    }

    @PutMapping("/examination/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ExaminationResponse reassemble(@PathVariable String id, @RequestBody ExaminationRequest examinationRequest) {
        Examination examination = examinationApplication.reassemble(id, examinationRequest);
        return ExaminationResponse.toExaminationResponse(examination);
    }

    @DeleteMapping("/examination/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable String id) {
        examinationApplication.delete(id);
    }

    @GetMapping("/examination/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ExaminationResponse find(@PathVariable String id) {
        Examination examination = examinationApplication.find(id);
        return ExaminationResponse.toExaminationResponse(examination);
    }
}
