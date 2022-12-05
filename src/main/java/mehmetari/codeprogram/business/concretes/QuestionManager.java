package mehmetari.codeprogram.business.concretes;

import mehmetari.codeprogram.business.abstracts.QuestionService;
import mehmetari.codeprogram.business.response.GetAllQuestionsResponse;
import mehmetari.codeprogram.entity.Question;
import mehmetari.codeprogram.entity.User;
import mehmetari.codeprogram.repository.QuestionRepository;
import mehmetari.codeprogram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class QuestionManager implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    UserRepository userRepository;

    @Override
    public Question add(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<GetAllQuestionsResponse> getAll() {
        List<Question> questionOptional = questionRepository.findAll();
        List<GetAllQuestionsResponse> getAllQuestionsResponse = new ArrayList<>();
        for (Question question : questionOptional) {
            GetAllQuestionsResponse getAllQuestionsResponse1 = new GetAllQuestionsResponse();
            getAllQuestionsResponse1.setTitle(question.getTitle());
            getAllQuestionsResponse1.setEmail(question.getUser().getEmail());
            getAllQuestionsResponse.add(getAllQuestionsResponse1);
        }

        return getAllQuestionsResponse;
    }

    public User getUser(int id){
        return userRepository.findById(id).get();
    }
}
