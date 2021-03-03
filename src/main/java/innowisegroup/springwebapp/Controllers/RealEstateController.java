package innowisegroup.springwebapp.Controllers;


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
        return realtyService.getAllRealty(false);
    }

    @GetMapping("{id}")
    public RealEstate getOne(@PathVariable("id") Long id){
        return realtyService.getOne(id);
    }

    @PostMapping
    public<T  extends RealEstate> RealEstate add(@RequestBody T realEstate){
        return realtyService.save(realEstate);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        realtyService.softDelete(id);
    }


    @PutMapping("{id}")
    public RealEstate update(@PathVariable("id") RealEstate realEstateFromDb, @RequestBody RealEstate realEstate){
        BeanUtils.copyProperties(realEstate,realEstateFromDb,"id");
        return realtyService.save(realEstateFromDb);
    }

}
