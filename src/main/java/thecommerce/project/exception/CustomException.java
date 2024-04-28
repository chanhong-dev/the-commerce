package thecommerce.project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import thecommerce.project.enums.ErrorCode;

@AllArgsConstructor
@Getter
public class CustomException extends RuntimeException{
    private final ErrorCode errorCode;
}

