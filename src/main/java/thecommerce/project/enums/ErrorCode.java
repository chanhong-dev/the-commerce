package thecommerce.project.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    NOT_FOUND_CONTENT_EXCEPTION(404, "존재하지 않는 콘텐츠 입니다. "),
    DUPLICATED_CONTENT_NAME(409, "이미 존재하는 콘텐츠 이름 입니다. "),
    CANNOT_DELETE_S3_OBJECT(500, "객체 삭제에 실패하였습니다. 관리자에게 문의 해주세요."),
    INVALID_CONTENT_NAME(400, "옳지 않은 콘텐츠 ID 형식 입니다.");

    private final Integer status;
    private final String message;
}