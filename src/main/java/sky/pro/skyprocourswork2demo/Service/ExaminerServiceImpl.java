package sky.pro.skyprocourswork2demo.Service;

import org.springframework.stereotype.Service;
import sky.pro.skyprocourswork2demo.Exeption.NotEnoughQuestionExeption;
import sky.pro.skyprocourswork2demo.Question.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{

    private final QuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> questions = questionService.getAll();
        if (amount > questions.size()  || amount < 1) {
            throw new NotEnoughQuestionExeption();
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount ) {
            result.add(questionService.getRandomQuestion());
        }
            return result;
    }
}
