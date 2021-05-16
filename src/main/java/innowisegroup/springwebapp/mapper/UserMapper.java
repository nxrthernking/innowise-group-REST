package innowisegroup.springwebapp.mapper;

import innowisegroup.springwebapp.model.User;
import innowisegroup.springwebapp.model.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapToUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .build();
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(user.getId(), user.getUsername(), user.getPassword());
    }
}
