package sky.pro.skyprocourswork2demo.Controller;

import org.springframework.web.bind.annotation.*;
import sky.pro.skyprocourswork2demo.Question.Question;
import sky.pro.skyprocourswork2demo.Service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping(path = "/get/{amount}")
    public Collection<Question> getQuestion(@PathVariable int amount) {

        return examinerService.getQuestions(amount);

    }
}
