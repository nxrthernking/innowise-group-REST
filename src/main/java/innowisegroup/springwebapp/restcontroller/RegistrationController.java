package innowisegroup.springwebapp.restcontroller;

import innowisegroup.springwebapp.model.dto.UserDto;
import innowisegroup.springwebapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest/registration")
public class RegistrationController {

    private final UserService userService;

    @PostMapping
    public UserDto registration(@RequestBody UserDto request){
        return userService.addUser(request);
    }
}
