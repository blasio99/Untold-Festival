package dev.blasio99.untoldfestival.server.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.blasio99.untoldfestival.server.model.User;

public interface UserRepository extends CrudRepository<User, Long>  {
    public User findByUsername(String username);
    public List<User> findByRole(String role);
}