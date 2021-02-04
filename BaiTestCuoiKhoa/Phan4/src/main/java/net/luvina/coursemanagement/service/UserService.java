package net.luvina.coursemanagement.service;

import net.luvina.coursemanagement.dto.UserDto;
import net.luvina.coursemanagement.dto.UserResponseDto;
import net.luvina.coursemanagement.entity.User;
import net.luvina.coursemanagement.error.ErrorCodes;
import net.luvina.coursemanagement.error.ServiceRuntimeException;
import net.luvina.coursemanagement.factory.UserFactory;
import net.luvina.coursemanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserFactory userFactory;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public UserResponseDto saveUser(UserDto userDto) {
        UserResponseDto userResponseDto;
        if (Objects.isNull(findUserByEmail(userDto.getEmail()))) {
            User user = userFactory.createUser(userDto);
            User saveUser = userRepository.save(user);
            return modelMapper.map(saveUser, UserResponseDto.class);
        }
        throw new ServiceRuntimeException(HttpStatus.valueOf(409),
                ErrorCodes.USER_E001,
                String.format("Email ( %s ) is already in use.", userDto.getEmail()));
    }

    @Transactional
    public User findUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }
}
