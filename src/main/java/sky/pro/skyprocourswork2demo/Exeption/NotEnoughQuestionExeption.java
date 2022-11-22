package sky.pro.skyprocourswork2demo.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT)
public class NotEnoughQuestionExeption extends RuntimeException{
}
