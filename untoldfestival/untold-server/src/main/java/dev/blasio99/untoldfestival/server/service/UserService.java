package dev.blasio99.untoldfestival.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.blasio99.untoldfestival.server.model.User;
import dev.blasio99.untoldfestival.server.repo.UserRepository;

@Service
public class UserService {
    
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @Autowired 
    private ValidationService validator;

    public User registerUser(User user) throws ServiceException {
        //validate username and password
        if (!validator.validateUsername(user.getUsername())) 
			throw new ServiceException("Invalid username!", HttpStatus.UNPROCESSABLE_ENTITY);
        if (!validator.validatePassword(user.getPassword())) 
			throw new ServiceException("Invalid password!", HttpStatus.UNPROCESSABLE_ENTITY);

        //check if username is available
        User u = userRepository.findByUsername(user.getUsername());
        if (u != null) throw new ServiceException("Username already taken!", HttpStatus.CONFLICT);

        //encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //persist user
        return userRepository.save(user);
    }

    public List<User> getCashiers() {
        return userRepository.findByRole("CASHIER");
    }

    public User getUserByUsername(String username) throws ServiceException {
        User user =  userRepository.findByUsername(username);
        if (user == null) throw new ServiceException("User not found", HttpStatus.NOT_FOUND);
        return user;
    }

	public User updateUser(User user) throws ServiceException {
        User u = userRepository.findByUsername(user.getUsername());
        //check if username is available
        if (u != null && !(u.getId().equals(user.getId()))) throw new ServiceException("Username is taken!", HttpStatus.CONFLICT);
        return userRepository.save(user);
    }

    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) return;
        userRepository.delete(user);
    }

}