package thecommerce.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thecommerce.project.domain.User;
import thecommerce.project.dto.request.UserRequestDto;
import thecommerce.project.dto.response.UserResponseDto;
import thecommerce.project.enums.ErrorCode;
import thecommerce.project.exception.CustomException;
import thecommerce.project.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
        private final UserRepository userRepository;


    public ResponseEntity<?> joinUser(UserRequestDto userJoinRequestDto) {
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

    public ResponseEntity<?> getUsers(int page, int pageSize, String sort) {
        List<UserResponseDto> userDtos = new ArrayList<>();
        Pageable pageable = PageRequest.of(page-1, pageSize,Sort.by(sort).ascending());
        Page<User> users =  userRepository.findAll(pageable);

        for (User user: users) {
            userDtos.add(UserResponseDto.builder()
                            .userId(user.getUserId())
                            .name(user.getName())
                            .email(user.getEmail())
                            .nickname(user.getNickname())
                            .phone(user.getPhone())
                    .build()
            );
        }

        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<?> updateUser(String userId, UserRequestDto userRequestDto) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new CustomException(ErrorCode.NOT_FOUND_USER);
        }else {
            user.update(userRequestDto.getPassword(), userRequestDto.getNickname(), userRequestDto.getName(), userRequestDto.getPhone(), userRequestDto.getEmail());
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }


}
