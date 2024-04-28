package thecommerce.project.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    NOT_FOUND_USER(404, "존재하지 않는 유저 입니다. "),
    DUPLICATED_USER_ID(409, "이미 존재하는 유저 아이디 입니다. ");

    private final Integer status;
    private final String message;
}