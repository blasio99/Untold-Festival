package dev.blasio99.untoldfestival.common.dto;

public class UserDTO extends BaseDTO{
    
    private String username;
    private String role;

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}


    
}