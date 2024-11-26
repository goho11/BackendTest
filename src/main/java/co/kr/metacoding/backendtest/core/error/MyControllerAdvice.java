package co.kr.metacoding.backendtest.core.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(Exception400.class)
    public ResponseEntity<?> err400(Exception400 e){
        return new ResponseEntity(new ErrorResp(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception404.class)
    public ResponseEntity<?> err404(Exception404 e) {
        return new ResponseEntity(new ErrorResp(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}