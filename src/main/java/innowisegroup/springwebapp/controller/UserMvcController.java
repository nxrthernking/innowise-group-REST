package innowisegroup.springwebapp.controller;

import innowisegroup.springwebapp.model.dto.UserDto;
import innowisegroup.springwebapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserMvcController {

    private final UserService userService;

    @GetMapping
    public String getAllUsers(Model model){
        List<UserDto> users = userService.getAllUsers();
        model.addAttribute("users",users);
        return "users";
    }

    @GetMapping(value = "/registration")
    public String getRegistrationPage(Model model){
        model.addAttribute("user",new UserDto());
        return "user-add";
    }

    @PostMapping(value = "/registration")
    public String submitUser(@ModelAttribute UserDto request, Model model){
        userService.addUser(request);
        return "redirect:/users";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        userService.remove(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/update/{id}")
    public String getUpdatePage(@PathVariable(value = "id") Long id, Model model){
        UserDto userDto = userService.getOne(id);
        model.addAttribute("user",userDto);
        return "user-update";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute UserDto request){
        userService.addUser(request);
        return "redirect:/users";
    }
}
