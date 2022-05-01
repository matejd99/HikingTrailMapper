package me.matej.hikingtrailmapper.service;

import me.matej.hikingtrailmapper.contracts.SignUpRequest;
import me.matej.hikingtrailmapper.dtos.UserDto;

public interface UserService {
    public UserDto userLogin(String userName, String Password);
    public UserDto signUp(SignUpRequest request);
}
