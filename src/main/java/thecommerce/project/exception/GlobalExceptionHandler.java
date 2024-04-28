package thecommerce.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import thecommerce.project.dto.response.ErrorResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ CustomException.class })
    protected ResponseEntity handleCustomException(CustomException exception) {
        System.out.println(exception.getErrorCode().getMessage());
        exception.printStackTrace();
        return new ResponseEntity(new ErrorResponseDto(exception.getErrorCode().getStatus(), exception.getErrorCode().getMessage()),
                HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }
}