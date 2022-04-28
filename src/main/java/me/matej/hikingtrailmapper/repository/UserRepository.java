package me.matej.hikingtrailmapper.repository;

import me.matej.hikingtrailmapper.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends JpaRepository<User, Long> {

    User findByUsernName(String userName);
    User findByUserNameAndPassword(String userName, String password);

}
