package thecommerce.project.dto.request;

import lombok.Getter;

@Getter
public class UserJoinRequestDto {

    private String userId;

    private String password;

    private String nickname;

    private String name;

    private String phone;

    private String email;
}
