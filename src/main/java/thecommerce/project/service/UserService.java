package thecommerce.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import thecommerce.project.domain.User;
import thecommerce.project.dto.request.UserJoinRequestDto;
import thecommerce.project.enums.ErrorCode;
import thecommerce.project.exception.CustomException;
import thecommerce.project.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
        private final UserRepository userRepository;


    public ResponseEntity<?> joinUser(UserJoinRequestDto userJoinRequestDto) {
        String userId = userJoinRequestDto.getUserId();
        // 회원 ID 중복 확인
        Optional<User> found = userRepository.findById(userId);
        if (found.isPresent()) {
            throw new CustomException(ErrorCode.DUPLICATED_USER_ID);
        }

        userRepository.save(User.builder()
                .userId(userJoinRequestDto.getUserId())
                .password(userJoinRequestDto.getPassword())
                .nickname(userJoinRequestDto.getNickname())
                .name(userJoinRequestDto.getName())
                .email(userJoinRequestDto.getEmail())
                .phone(userJoinRequestDto.getPhone())
                .build()
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
