package innowisegroup.springwebapp.service;

import innowisegroup.springwebapp.repository.RealEstateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class RealEstateServiceTest {

    @Mock
    private RealEstateRepository repository;

    @InjectMocks
    private RealEstateService service;

    @Test
    public void shouldGetAllRealEstateOnGetAllRealty(){

    }
}