package innowisegroup.springwebapp.Services;

import innowisegroup.springwebapp.Entities.Role;
import innowisegroup.springwebapp.Entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;

@RunWith(MockitoJUnitRunner.class)
class UserServiceTest {

    @Mock
    private UserService mock;

    private User user;

    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void initUser(){
        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");
        LinkedList<Role> list = new LinkedList<>();
        list.add(adminRole);
        list.add(userRole);
        user = new User("admin","admin",list);
    }

    @Test
    void findByUsername() {
        Mockito.when(mock.findByUsername("admin")).thenReturn(user);
        Assert.assertEquals(mock.findByUsername("admin"),user);
    }

    @Test
    void getOne() {
        Mockito.when(mock.getOne(1L)).thenReturn(user);
        Assert.assertEquals(mock.getOne(1L),user);
    }
}