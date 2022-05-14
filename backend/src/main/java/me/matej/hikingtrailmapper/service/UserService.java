package me.matej.hikingtrailmapper.service;

import me.matej.hikingtrailmapper.contracts.SignUpRequest;
import me.matej.hikingtrailmapper.dtos.UserDto;

public interface UserService {
    UserDto userLogin(String userName, String Password);
    UserDto signUp(SignUpRequest request);
}
