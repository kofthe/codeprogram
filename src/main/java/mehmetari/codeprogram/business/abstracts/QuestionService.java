package mehmetari.codeprogram.business.abstracts;

import mehmetari.codeprogram.business.response.GetAllQuestionsResponse;
import mehmetari.codeprogram.entity.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {

    Question add(Question question);

    List<GetAllQuestionsResponse> getAll();


}
