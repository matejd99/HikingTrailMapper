package me.matej.hikingtrailmapper.service.impl;

import me.matej.hikingtrailmapper.contracts.SignUpRequest;
import me.matej.hikingtrailmapper.dtos.UserDto;
import me.matej.hikingtrailmapper.model.User;
import me.matej.hikingtrailmapper.repository.UserRepository;
import me.matej.hikingtrailmapper.service.UserService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto userLogin(String userName, String password) {
        User user = userRepository.findByUserName(userName);

        if (user == null || !user.getPassword().equals(password)) {
//            throw new UsernameNotFoundException("");
        }

        return user.toDto();
    }

    @Override
    public UserDto signUp(SignUpRequest request) {
        User user = userRepository.findByUserName(request.getUserName());

        if (user != null) {
//            throw new UsernameNotFoundException(""); // User already exists
        }

        if (request.getUserName().isBlank() ||
                request.getPassword().length() < 4) {
//            throw new UsernameNotFoundException(""); // Whatever validation
        }

        user = new User(
                request.getFirstName(),
                request.getLastName(),
                request.getUserName(),
                request.getPassword(),
                "");

        return userRepository.save(user).toDto();
    }
}
