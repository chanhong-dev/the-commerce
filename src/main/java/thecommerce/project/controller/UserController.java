package thecommerce.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import thecommerce.project.dto.request.UserJoinRequestDto;
import thecommerce.project.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/join")
    public ResponseEntity<?> joinUser(@RequestBody UserJoinRequestDto userJoinRequestDto){

        return userService.joinUser(userJoinRequestDto);
    }
}
