package dev.blasio99.untoldfestival.server.api.assembler;

import org.springframework.stereotype.Component;

import dev.blasio99.untoldfestival.common.dto.UserDTO;
import dev.blasio99.untoldfestival.server.model.User;

@Component
public class UserAssembler implements BaseAssembler<UserDTO, User> {

    @Override
    public User createModel(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setRole(dto.getRole());
        return user;
    }

    @Override
    public UserDTO createDTO(User model) {
        UserDTO dto = new UserDTO();
        dto.setId(model.getId());
        dto.setUsername(model.getUsername());
        dto.setRole(model.getRole());
        return dto;
    }
}