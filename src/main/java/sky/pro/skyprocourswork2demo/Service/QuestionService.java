package sky.pro.skyprocourswork2demo.Service;

import sky.pro.skyprocourswork2demo.Question.Question;

import java.util.Collection;
import java.util.List;

public interface QuestionService {
    Question addQuestion(String question, String answer);

    Question addQuestion(Question question);

    Question removeQuestion(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
