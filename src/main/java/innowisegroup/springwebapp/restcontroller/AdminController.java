package innowisegroup.springwebapp.restcontroller;


import innowisegroup.springwebapp.model.RealEstate;
import innowisegroup.springwebapp.model.dto.UserDto;
import innowisegroup.springwebapp.service.RealEstateService;
import innowisegroup.springwebapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    private final RealEstateService realEstateService;

    @GetMapping(value = "/users")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/realty")
    public List<RealEstate> getAllRealEstate(){
        return realEstateService.getAllRealty();
    }

}
