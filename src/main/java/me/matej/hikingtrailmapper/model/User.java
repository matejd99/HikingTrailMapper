package me.matej.hikingtrailmapper.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Setter @Getter
    private String firstName, lastName, userName, password, imagePath;

    @Setter @Getter
    private int id;
}
