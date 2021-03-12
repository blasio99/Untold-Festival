package dev.blasio99.untoldfestival.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.godraadam.untold.model.Role;
import dev.godraadam.untold.model.User;

public interface UserRepository extends CrudRepository<User, Long>  {
    public User findByUserName(String username);
    public List<User> findByRole(String role);
}