package exam.examinationContext.domain.model.examination;

import java.util.Optional;

public interface ExaminationRepository {
    Examination save(Examination examination);

    void delete(Examination examination);

    Optional<Examination> findById(ExaminationId examinationId);
}
