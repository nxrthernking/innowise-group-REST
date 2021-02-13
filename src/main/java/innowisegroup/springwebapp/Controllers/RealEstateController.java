package innowisegroup.springwebapp.Controllers;


import innowisegroup.springwebapp.Entities.Flat;
import innowisegroup.springwebapp.Entities.House;
import innowisegroup.springwebapp.Entities.RealEstate;
import innowisegroup.springwebapp.Services.RealEstateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realty")
public class RealEstateController {

    private final RealEstateService realtyService;

    public RealEstateController(RealEstateService realtyService) {
        this.realtyService = realtyService;
    }

    @GetMapping
    public List<RealEstate> getAllRealty(){
        return realtyService.getAllRealty();
    }

    @GetMapping("/{id}")
    public RealEstate getOne(@PathVariable Long id){
        return realtyService.getOne(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRealty(@PathVariable Long id){
        realtyService.deleteRealtyById(id);
    }

    @PostMapping("/flat/add")
    public RealEstate addFlat(@RequestBody Flat flat){
        return realtyService.addRealty(flat);
    }

    @PostMapping("/house/add")
    public RealEstate addHouse(@RequestBody House house){
        return realtyService.addRealty(house);
    }
}
