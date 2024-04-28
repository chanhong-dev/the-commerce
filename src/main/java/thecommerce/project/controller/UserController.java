package thecommerce.project.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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


    @Tag(name = "USER API")
    @Operation(summary = "회원가입", description = "유저 회원가입 api")
    @PostMapping(value = "/join")
    public ResponseEntity<?> joinUser(@Validated @RequestBody UserRequestDto userJoinRequestDto){

        return userService.joinUser(userJoinRequestDto);
    }

    @Tag(name = "USER API")
    @Operation(summary = "유저조회", description = "유저 조회 api")
    @GetMapping("/list")
    public ResponseEntity<?> getUsers(@RequestParam(value = "page") int page,
                                      @RequestParam(value = "pageSize") int pageSize,
                                      @RequestParam(value = "sort", defaultValue = "name") String sort){

        return userService.getUsers(page, pageSize, sort);
    }

    @Tag(name = "USER API")
    @Operation(summary = "유저 수정", description = "유저 수정 api")
    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable String userId,
                             @RequestBody UserRequestDto userRequestDto) {

        return userService.updateUser(userId, userRequestDto);
    }
}
