package thecommerce.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/list")
    public ResponseEntity<?> getUsers(@RequestParam(value = "page") int page,
                                      @RequestParam(value = "pageSize") int pageSize,
                                      @RequestParam(value = "sort", defaultValue = "name") String sort){

        return userService.getUsers(page, pageSize, sort);
    }
}
