package innowisegroup.springwebapp.restcontroller;


import innowisegroup.springwebapp.model.Flat;
import innowisegroup.springwebapp.model.House;
import innowisegroup.springwebapp.model.RealEstate;
import innowisegroup.springwebapp.service.RealEstateService;
import innowisegroup.springwebapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/rest/realty")
@RequiredArgsConstructor
public class RealEstateController {

    private final RealEstateService realtyService;

    private final UserService userService;

    @GetMapping
    public List<RealEstate> getAllRealty() {
        return realtyService.getAllRealty();
    }

    @GetMapping("{id}")
    public RealEstate getOne(@PathVariable("id") Long id) {
        return realtyService.getOne(id);
    }

/*    @PostMapping
    public<T  extends RealEstate> RealEstate add(@RequestBody T realEstate){
        return realtyService.save(realEstate);
    }*/

    @PostMapping(value = "/add/flat", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RealEstate addFlat(@RequestBody Flat flat, Principal principal) {
        flat.setUser(userService.findByUsername(principal.getName()));
        return realtyService.save(flat);
    }

    @PostMapping(value = "/add/house", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RealEstate addHouse(@RequestBody House house, Principal principal) {
        house.setUser(userService.findByUsername(principal.getName()));
        return realtyService.save(house);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        realtyService.softDelete(id);
    }


//    @PutMapping("{id}")
//    public RealEstate update(@PathVariable("id") RealEstate realEstateFromDb, @RequestBody RealEstate realEstate) {
//        BeanUtils.copyProperties(realEstate, realEstateFromDb, "id");
//        return realtyService.save(realEstateFromDb);
//    }


}
