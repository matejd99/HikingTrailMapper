package me.matej.hikingtrailmapper.contracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignUpRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String imageUrl;
}
