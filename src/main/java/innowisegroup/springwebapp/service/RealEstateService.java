package innowisegroup.springwebapp.service;

import innowisegroup.springwebapp.exception.RealEstateNotFoundException;
import innowisegroup.springwebapp.model.RealEstate;
import innowisegroup.springwebapp.repository.RealEstateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RealEstateService {

    private final RealEstateRepository realtyRepository;


    public List<RealEstate> getAllRealty(){
        return realtyRepository.findAll();
    }

    public RealEstate save(RealEstate realty){
        return realtyRepository.save(realty);
    }

    public RealEstate getOne(Long id){
        return realtyRepository.findById(id).orElseThrow(RealEstateNotFoundException::new);
    }

    public void softDelete(Long id){


    }
}
