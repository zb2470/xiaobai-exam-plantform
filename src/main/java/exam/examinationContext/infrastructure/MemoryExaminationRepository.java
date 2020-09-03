package exam.examinationContext.infrastructure;

import exam.examinationContext.domain.model.examination.Examination;
import exam.examinationContext.domain.model.examination.ExaminationId;
import exam.examinationContext.domain.model.examination.ExaminationRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MemoryExaminationRepository implements ExaminationRepository {
    private Set<Examination> examinations = new HashSet<>();

    @Override
    public Examination save(Examination examination) {
        examinations.add(examination);
        return examination;
    }

    @Override
    public void delete(Examination examination) {
        examinations.remove(examination);
    }

    @Override
    public Optional<Examination> findById(ExaminationId examinationId) {
        return examinations.stream().filter(examination -> examination.getExaminationId().equals(examinationId)).findFirst();
    }
}
