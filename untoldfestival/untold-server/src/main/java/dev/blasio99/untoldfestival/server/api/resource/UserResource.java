package dev.blasio99.untoldfestival.server.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.blasio99.untoldfestival.common.dto.UserDTO;
import dev.blasio99.untoldfestival.common.dto.UserRegisterDTO;

import dev.blasio99.untoldfestival.server.api.assembler.UserAssembler;
import dev.blasio99.untoldfestival.server.api.assembler.UserRegisterAssembler;
import dev.blasio99.untoldfestival.server.model.User;
import dev.blasio99.untoldfestival.server.service.ServiceException;
import dev.blasio99.untoldfestival.server.service.UserService;


@CrossOrigin("*")
@RestController
public class UserResource {

    @Autowired
    private UserAssembler userAssembler;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRegisterAssembler userRegisterAssembler;

	@PostMapping("/login")
    public UserDTO login(@RequestBody UserRegisterDTO dto) {
        return userAssembler.createDTO(userService.login(userRegisterAssembler.createModel(dto)));
    }

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

    @PostMapping("/admin/api/register/admin")
	@ResponseStatus(HttpStatus.CREATED)
    public UserDTO registerAdmin(@RequestBody UserRegisterDTO dto) {
        //try {
            User user = userService.registerAdmin(userRegisterAssembler.createModel(dto));
            return userAssembler.createDTO(user);
        //} catch (ServiceException e) {
        //    return new ResponseEntity<>(e.getHttpStatus());
        //}
    }

	@PostMapping("/admin/api/register/cashier")
	@ResponseStatus(HttpStatus.CREATED)
    public UserDTO registerCashier(@RequestBody UserRegisterDTO dto) {
            User user = userService.registerCashier(userRegisterAssembler.createModel(dto));
            return userAssembler.createDTO(user);
        
    }

    @DeleteMapping("/admin/api/delete/user/{username}")
    public void removeUser(@PathVariable String username) {
        userService.deleteUser(username);
    }
    
}