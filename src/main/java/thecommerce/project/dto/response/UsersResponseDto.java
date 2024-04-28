package thecommerce.project.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UsersResponseDto {
    private String userId;

    private String nickname;

    private String name;

    private String phone;

    private String email;
}
