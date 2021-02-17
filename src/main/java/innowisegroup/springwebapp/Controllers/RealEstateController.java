package innowisegroup.springwebapp.Controllers;


import innowisegroup.springwebapp.Entities.Flat;
import innowisegroup.springwebapp.Entities.House;
import innowisegroup.springwebapp.Entities.RealEstate;
import innowisegroup.springwebapp.Services.RealEstateService;
import org.springframework.beans.BeanUtils;
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

    @GetMapping("{id}")
    public RealEstate getOne(@PathVariable("id") Long id){
        return realtyService.getOne(id);
    }

    @PostMapping("/flat")
    public RealEstate addFlat(@RequestBody Flat realEstate){
        return realtyService.save(realEstate);
    }

    @PostMapping("/house")
    public RealEstate addHouse(@RequestBody House house){
        return realtyService.save(house);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        System.out.println(id);
        //realtyService.delete(realEstate);
    }


    @PutMapping("{id}")
    public RealEstate update(@PathVariable("id") RealEstate realEstateFromDb,
                                 @RequestBody RealEstate realEstate){
        BeanUtils.copyProperties(realEstate,realEstateFromDb,"id");
        return realtyService.save(realEstateFromDb);
    }

}
