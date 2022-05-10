package me.matej.hikingtrailmapper.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.matej.hikingtrailmapper.dtos.UserDto;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(name = "uc_user_username", columnNames = {"userName"})
})
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String userName;

    @Column
    private String password;

    @Column
    private String imagePath;

    @OneToMany(mappedBy = "user")
    private List<Trail> trails;

    public User(String firstName, String lastName, String userName, String password, String imagePath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.imagePath = imagePath;
    }

    public UserDto toDto() {
        return new UserDto(id, firstName, lastName, userName, imagePath);
    }
}
