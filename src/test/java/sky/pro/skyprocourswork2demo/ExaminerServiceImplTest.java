package sky.pro.skyprocourswork2demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.skyprocourswork2demo.Exeption.NotEnoughQuestionExeption;
import sky.pro.skyprocourswork2demo.Exeption.QuestionAlreadeExistExeption;
import sky.pro.skyprocourswork2demo.Question.Question;
import sky.pro.skyprocourswork2demo.Service.ExaminerServiceImpl;
import sky.pro.skyprocourswork2demo.Service.JavaQuestionService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final List<Question> javaQuestions = new ArrayList<>();

    @BeforeEach
    public void beforeEach() {
        javaQuestions.clear();

        javaQuestions.addAll(
                Stream.of(
                                new Question("Question1", "Answer1"),
                                new Question("Question2", "Answer2"),
                                new Question("Question3", "Answer3"))
                        .collect(Collectors.toSet())
        );

        when(questionService.getAll()).thenReturn(javaQuestions);
    }

    @Test
    public void getQuestionNegativeTest() {
        assertThatExceptionOfType(NotEnoughQuestionExeption.class)
                .isThrownBy(() -> examinerService.getQuestions(-1));

    }

    @Test
    public void getQuestionPositiveTest() {
        when(questionService.getRandomQuestion()).thenReturn(
                new Question("Question1", "Answer1"),
                new Question("Question2", "Answer2"),
                new Question("Question1", "Answer1"),
                new Question("Question3", "Answer3"),
                new Question("Question2", "Answer2"));
        assertThat(examinerService.getQuestions(3))
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        new Question("Question1", "Answer1"),
                        new Question("Question2", "Answer2"),
                        new Question("Question3", "Answer3"));
    }
}
