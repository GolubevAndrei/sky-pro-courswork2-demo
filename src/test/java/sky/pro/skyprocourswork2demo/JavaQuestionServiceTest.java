package sky.pro.skyprocourswork2demo;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import sky.pro.skyprocourswork2demo.Exeption.QuestionAlreadeExistExeption;
import sky.pro.skyprocourswork2demo.Exeption.QuestionNotFoundExeption;
import sky.pro.skyprocourswork2demo.Question.Question;
import sky.pro.skyprocourswork2demo.Service.JavaQuestionService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class JavaQuestionServiceTest {

    private final JavaQuestionService questionService = new JavaQuestionService();

    @ParameterizedTest
    @MethodSource("question1")
    public void addTest1(String question, String answer) {
        Question qst = new Question(question, answer);
        questionService.addQuestion(question, answer);
        assertThatExceptionOfType(QuestionAlreadeExistExeption.class)
                .isThrownBy(() -> questionService.addQuestion(question, answer));
        assertThat(questionService.getAll()).containsExactlyInAnyOrder(qst);
    }

    @ParameterizedTest
    @MethodSource("question2")
    public void addTest2(Question question) {
        questionService.addQuestion(question);
        assertThatExceptionOfType(QuestionAlreadeExistExeption.class)
                .isThrownBy(() -> questionService.addQuestion(new Question(question.getQuestion(), question.getAnswer())));
        assertThat(questionService.getAll()).containsExactlyInAnyOrder(question);
    }

    @ParameterizedTest
    @MethodSource("question2")
    public void removeTest(Question question) {
        questionService.addQuestion(question);
        questionService.removeQuestion(question);
        assertThatExceptionOfType(QuestionNotFoundExeption.class)
                .isThrownBy(() -> questionService.removeQuestion(question));

    }

    @ParameterizedTest
    @MethodSource("questions")
    public void getRandomQuestionTest(Set<Question> questions) {
        questions.forEach(questionService::addQuestion);
        assertThat(questionService.getRandomQuestion()).isIn(questionService.getAll());

    }

    public static Stream<Arguments> question1(){
        return Stream.of(
                Arguments.of("Question", "Answer"));

    }
    public static Stream<Arguments> question2(){
        return Stream.of(
            Arguments.of(new Question("Question", "Answer")));

    }
    public static Stream<Arguments> questions(){
        return Stream.of(
                Arguments.of(
                        Set.of(
                                new Question("Question1", "Answer1"),
                                new Question("Question2", "Answer2"),
                                new Question("Question3", "Answer3"))));

    }
}











