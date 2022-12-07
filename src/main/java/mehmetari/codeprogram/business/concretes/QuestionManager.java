package mehmetari.codeprogram.business.concretes;

import mehmetari.codeprogram.business.abstracts.QuestionService;
import mehmetari.codeprogram.business.request.question.CreateQuestionRequest;
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
    @Autowired
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

    @Override
    public Question addQuestion(CreateQuestionRequest createQuestionRequest) {
        Question question = new Question();
        User user = userRepository.getReferenceById(createQuestionRequest.getUserId());
        question.setTitle(createQuestionRequest.getTitle());
        question.setDescription(createQuestionRequest.getDescription());
        question.setUser(user);
        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(int id) {
        isIdExist(id);
        questionRepository.deleteById(id);
    }

    public User getUser(int id){
        return userRepository.findById(id).get();
    }


    public boolean isIdExist(int id) {
        List<User> userlist = userRepository.findAll();
        for (User user : userlist){
            if (user.getId() == id) return true;

        }
        return false;

    }

}
