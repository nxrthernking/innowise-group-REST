package innowisegroup.springwebapp.restcontroller;

import innowisegroup.springwebapp.model.dto.UserDto;
import innowisegroup.springwebapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public UserDto getById(@PathVariable(value = "id") Long id){
        return userService.getOne(id);
    }

    @PostMapping(value = "/add")
    public void add(@RequestBody UserDto request){
        userService.addUser(request);
    }

}
