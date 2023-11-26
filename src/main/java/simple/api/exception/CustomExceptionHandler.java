package simple.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<CustomErrorResponseEntity> handleCustomException(CustomException e) {
        return CustomErrorResponseEntity.toResponse(e.getCustomErrorCode());
    }
}
