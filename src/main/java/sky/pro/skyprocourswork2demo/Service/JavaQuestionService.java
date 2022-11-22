package sky.pro.skyprocourswork2demo.Service;

import org.springframework.stereotype.Service;
import sky.pro.skyprocourswork2demo.Exeption.QuestionAlreadeExistExeption;
import sky.pro.skyprocourswork2demo.Question.Question;
import sky.pro.skyprocourswork2demo.Exeption.QuestionNotFoundExeption;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;
    private final Random random;

    public JavaQuestionService() {
        this.questions = new HashSet<>();
        this.random = new Random();
    }

    @Override
    public Question addQuestion(String question, String answer) {

        return addQuestion(new Question(question, answer));
    }
    @Override
    public Question addQuestion(Question question) {
        // if (questions.contains(question)) {
        if (!questions.add(question)) {
            throw new QuestionAlreadeExistExeption();
        }
        return question;
    }
    @Override
    public Question removeQuestion(Question question) {
        // if (questions.contains(question)) {
        if (!questions.remove(question)) {
            throw new QuestionNotFoundExeption("Question " + question +": not found");
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questions);
        /* правильно
        return new HashSet<>(questions);
         */
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.size() == 0) {
            return null;
        }
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
        /* правильно
        return questions.stream().skip(random.nextInt(questions.size()))
                .findAny()
                .orElse(null);
         */
    }

}
