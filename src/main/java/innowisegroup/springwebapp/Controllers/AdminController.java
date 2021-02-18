package innowisegroup.springwebapp.Controllers;


import innowisegroup.springwebapp.Entities.RealEstate;
import innowisegroup.springwebapp.Entities.User;
import innowisegroup.springwebapp.Services.RealEstateService;
import innowisegroup.springwebapp.Services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    private final RealEstateService realEstateService;

    public AdminController(UserService userService, RealEstateService realEstateService) {
        this.userService = userService;
        this.realEstateService = realEstateService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    @GetMapping("/realty")
    public List<RealEstate> getAllRealEstate(){
        return realEstateService.getAllRealty();
    }
}
