package mehmetari.codeprogram.business.abstracts;

import mehmetari.codeprogram.business.request.question.CreateQuestionRequest;
import mehmetari.codeprogram.business.response.GetAllQuestionsResponse;
import mehmetari.codeprogram.entity.Question;


import java.util.List;

public interface QuestionService {

    Question add(Question question);

    List<GetAllQuestionsResponse> getAll();

    Question addQuestion(CreateQuestionRequest createQuestionRequest);


}
