package me.matej.hikingtrailmapper.service;

import me.matej.hikingtrailmapper.model.User;

public interface UserService {

    public User userLogin(String userName, String Password);

    public User userRegister(String firstName, String lastName, String userName, String password);

}
