package dev.blasio99.untoldfestival.server.api.assembler;

import org.springframework.stereotype.Component;

import dev.blasio99.untoldfestival.common.dto.UserRegisterDTO;

import dev.blasio99.untoldfestival.server.model.User;

@Component
public class UserRegisterAssembler implements BaseAssembler<UserRegisterDTO, User> {
    
    @Override
    public User createModel(UserRegisterDTO dto) {
        User user = new User();
        user.setPassword(dto.getPassword());
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setRole(dto.getRole());
        return user;
    }


    @Override
    public UserRegisterDTO createDTO(User model) {
        UserRegisterDTO dto = new UserRegisterDTO();
        dto.setId(model.getId());
        dto.setUsername(model.getUsername());
        dto.setPassword(model.getPassword());
        dto.setRole(model.getRole());
        return dto;
    }
}