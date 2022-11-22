package sky.pro.skyprocourswork2demo.Service;

import sky.pro.skyprocourswork2demo.Question.Question;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
