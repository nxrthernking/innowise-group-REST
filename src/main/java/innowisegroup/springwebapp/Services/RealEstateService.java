package innowisegroup.springwebapp.Services;

import innowisegroup.springwebapp.Entities.RealEstate;
import innowisegroup.springwebapp.Repositories.RealEstateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealEstateService {

    private final RealEstateRepository realtyRepository;

    public RealEstateService(RealEstateRepository realtyRepository) {
        this.realtyRepository = realtyRepository;
    }

    public List<RealEstate> getAllRealty(){
        return realtyRepository.findAll();
    }

    public RealEstate save(RealEstate realty){
        return realtyRepository.save(realty);
    }

    public RealEstate getOne(Long id){
        return realtyRepository.findById(id).get();
    }

    public void delete(RealEstate realEstate){
        realtyRepository.delete(realEstate);
    }
}