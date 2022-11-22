package sky.pro.skyprocourswork2demo.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class QuestionAlreadeExistExeption extends RuntimeException {
}
