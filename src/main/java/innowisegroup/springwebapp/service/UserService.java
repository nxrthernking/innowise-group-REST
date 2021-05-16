package innowisegroup.springwebapp.service;


import innowisegroup.springwebapp.exception.UserException;
import innowisegroup.springwebapp.mapper.UserMapper;
import innowisegroup.springwebapp.model.Role;
import innowisegroup.springwebapp.model.User;
import innowisegroup.springwebapp.model.dto.UserDto;
import innowisegroup.springwebapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final UserMapper mapper;


    private final PasswordEncoder passwordEncoder;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));

    }

    private Set<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(mapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    public UserDto addUser(UserDto request) {
        User user = findByUsername(request.getUsername());
        if (user != null) {
            throw new UserException("User with username: " + request.getUsername() + " already exist");
        }
        user = User.builder()
                .id(request.getId())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();


        return mapper.mapToUserDto(userRepository.save(user));
    }

    public UserDto getOne(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserException("User not found"));
        return mapper.mapToUserDto(user);
    }

    public void remove(Long id){
        userRepository.deleteById(id);
    }
}
