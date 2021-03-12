package dev.blasio99.untoldfestival.server.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.blasio99.untoldfestival.common.dto.UserDTO;
import dev.blasio99.untoldfestival.common.dto.UserRegisterDTO;

import dev.blasio99.untoldfestival.server.api.assembler.UserAssembler;
import dev.blasio99.untoldfestival.server.api.assembler.UserRegisterAssembler;
import dev.blasio99.untoldfestival.server.model.User;
import dev.blasio99.untoldfestival.server.service.ServiceException;
import dev.blasio99.untoldfestival.server.service.UserService;

@RestController
public class UserResource {

    @Autowired
    private UserAssembler userAssembler;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRegisterAssembler userRegisterAssembler;

    @GetMapping("/admin/api/user/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable("username") String username) {
        try {
            User user = userService.getUserByUsername(username);
            return new ResponseEntity<>(userAssembler.createDTO(user), HttpStatus.OK);
        } catch(ServiceException e) {
            return new ResponseEntity<>(e.getHttpStatus());
        }
    }

    @GetMapping("/admin/api/cashiers")
    public List<UserDTO> getCashiers() {
        return userAssembler.createDTOList(userService.getCashiers());
    }

    @PostMapping("/admin/api/user/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserRegisterDTO dto) {
        try {
            User user = userService.registerUser(userRegisterAssembler.createModel(dto));
            return new ResponseEntity<>(userAssembler.createDTO(user), HttpStatus.CREATED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getHttpStatus());
        }
    }

    @DeleteMapping("/admin/api/user/delete/{username}")
    public void removeUser(@PathVariable String username) {
        userService.deleteUser(username);
    }
    
}