package mehmetari.codeprogram.webapi.controller;

import mehmetari.codeprogram.business.abstracts.QuestionService;
import mehmetari.codeprogram.business.request.question.CreateQuestionRequest;
import mehmetari.codeprogram.business.response.GetAllQuestionsResponse;
import mehmetari.codeprogram.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping("/add")
    public Question add(Question question){
        return questionService.add(question);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<GetAllQuestionsResponse>> getAll(){
        return new ResponseEntity<>(questionService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/addquestion")
    public Question addQuestion(@RequestBody CreateQuestionRequest createQuestionRequest){
        return questionService.addQuestion(createQuestionRequest);
    }
}
