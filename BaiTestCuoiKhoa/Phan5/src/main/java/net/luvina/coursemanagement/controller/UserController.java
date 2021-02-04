package net.luvina.coursemanagement.controller;

import net.luvina.coursemanagement.dto.UserDto;
import net.luvina.coursemanagement.dto.UserResponseDto;
import net.luvina.coursemanagement.error.ApiError;
import net.luvina.coursemanagement.error.ServiceRuntimeException;
import net.luvina.coursemanagement.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {
    public final UserService userService;

    @PostMapping("/api/v1/users")
    @ApiOperation("Create user")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Create user successfully")
    })
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserResponseDto response = userService.saveUser(userDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/api/v2/users")
    @ApiOperation("Create user")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Create user successfully")
    })
    public ResponseEntity<UserResponseDto> createUserV2(@Valid @RequestBody UserDto userDto) {
        UserResponseDto response = userService.saveUser(userDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @ExceptionHandler({ServiceRuntimeException.class})
    public ResponseEntity<ApiError> handleServiceRuntimeException(ServiceRuntimeException ex) {
        ApiError apiError = new ApiError(ex.getErrorCode(), ex.getLocalizedMessage());

        return new ResponseEntity<>(apiError, ex.getHttpStatus());
    }
}
