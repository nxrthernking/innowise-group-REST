package innowisegroup.springwebapp.Services;

import innowisegroup.springwebapp.Entities.Flat;
import innowisegroup.springwebapp.Entities.RealEstate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
class RealEstateServiceTest {



    @Mock
    private RealEstateService mock;

    private RealEstate realEstate;

    @Test
    void save() {
        Mockito.when(mock.save(realEstate)).thenReturn(realEstate);
        Assert.assertEquals(mock.save(realEstate),realEstate);
    }

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void initRealEstate(){
        realEstate = new Flat("Gomel","Iverskaya","4",21.4,
                new BigDecimal("38076.00"),1,9,true);
    }

    @Test
    void getOne() {
        Mockito.when(mock.getOne(1L)).thenReturn(realEstate);
        Assert.assertEquals(mock.getOne(1L),realEstate);
    }
}