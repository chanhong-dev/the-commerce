package thecommerce.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import thecommerce.project.dto.request.UserRequestDto;
import thecommerce.project.service.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/join")
    public ResponseEntity<?> joinUser(@Validated @RequestBody UserRequestDto userJoinRequestDto){

        return userService.joinUser(userJoinRequestDto);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getUsers(@RequestParam(value = "page") int page,
                                      @RequestParam(value = "pageSize") int pageSize,
                                      @RequestParam(value = "sort", defaultValue = "name") String sort){

        return userService.getUsers(page, pageSize, sort);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable String userId,
                             @RequestBody UserRequestDto userRequestDto) {

        return userService.updateUser(userId, userRequestDto);
    }
}
