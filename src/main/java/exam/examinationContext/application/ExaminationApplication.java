package exam.examinationContext.application;

import exam.examinationContext.domain.model.examination.EntityNotFoundException;
import exam.examinationContext.domain.model.examination.Examination;
import exam.examinationContext.domain.model.examination.ExaminationId;
import exam.examinationContext.domain.model.examination.ExaminationRepository;
import exam.examinationContext.userInterface.request.ExaminationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExaminationApplication {
    private final ExaminationRepository examinationRepository;

    @Autowired
    public ExaminationApplication(ExaminationRepository examinationRepository) {
        this.examinationRepository = examinationRepository;
    }

    public Examination assemblePaper(ExaminationRequest examinationRequest) {
        Examination assemble = Examination.assemble(
                ExaminationId.nextId(),
                examinationRequest.getStudentIds(),
                examinationRequest.getTeacherIds(),
                examinationRequest.getAnswerSheetId(),
                examinationRequest.getPaperId()
        );
        return examinationRepository.save(assemble);
    }

    public Examination reassemble(String id, ExaminationRequest examinationRequest) {
        Optional<Examination> examinationOpt = examinationRepository.findById(new ExaminationId(id));
        if (!examinationOpt.isPresent()) {
            throw new EntityNotFoundException("not found :" + id);
        }
        Examination examination = examinationOpt.get().reassemble(
                examinationRequest.getStudentIds(),
                examinationRequest.getTeacherIds(),
                examinationRequest.getAnswerSheetId(),
                examinationRequest.getPaperId());
        return examinationRepository.save(examination);
    }

    public void delete(String id) {
        Optional<Examination> examinationOpt = examinationRepository.findById(new ExaminationId(id));
        if (!examinationOpt.isPresent()) {
            throw new EntityNotFoundException("not found :" + id);
        }
        examinationRepository.delete(examinationOpt.get());
    }

    public Examination find(String id) {
        Optional<Examination> examinationOpt = examinationRepository.findById(new ExaminationId(id));
        if (!examinationOpt.isPresent()) {
            throw new EntityNotFoundException("not found :" + id);
        }
        return examinationOpt.get();
    }
}
