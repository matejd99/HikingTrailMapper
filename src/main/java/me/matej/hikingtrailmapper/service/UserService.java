package me.matej.hikingtrailmapper.service;

import me.matej.hikingtrailmapper.contracts.SignUpRequest;
import me.matej.hikingtrailmapper.model.User;

public interface UserService {
    public User userLogin(String userName, String Password);
    public User signUp(SignUpRequest request);
}
