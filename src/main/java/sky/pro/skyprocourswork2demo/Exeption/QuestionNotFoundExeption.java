package sky.pro.skyprocourswork2demo.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class QuestionNotFoundExeption extends RuntimeException {
    public QuestionNotFoundExeption(String s) {
    }
}
