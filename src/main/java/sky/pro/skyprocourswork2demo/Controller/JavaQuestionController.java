package sky.pro.skyprocourswork2demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.skyprocourswork2demo.Question.Question;
import sky.pro.skyprocourswork2demo.Service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public String addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {

        questionService.addQuestion(question, answer);
        return "Question " + question + " " + answer + " add";
    }

    @GetMapping(path = "/remove")
    public String removeQuestion(@RequestParam("question") Question question) {

        questionService.removeQuestion(question);
        return "Question " + question + " remove";
    }

    @GetMapping()
    public Collection<Question> getQuestion() {

        return questionService.getAll();

    }
}
