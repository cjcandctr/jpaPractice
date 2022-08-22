package leon.jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchException extends RuntimeException{
    private String resource;
    public NoSuchException(String res) {
        super(res);
    }
}
