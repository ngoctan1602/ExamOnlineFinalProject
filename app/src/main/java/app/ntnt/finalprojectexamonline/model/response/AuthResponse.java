package app.ntnt.finalprojectexamonline.model.response;

import java.util.List;

public class AuthResponse {

    private String username;
    private Long id;
    private String token;
    private List<String> roles;

    public AuthResponse() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return id;
    }

    public void setUserId(Long userId) {
        this.id = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public AuthResponse(String username, Long id, String token, List<String> roles) {
        this.username = username;
        this.id = id;
        this.token = token;
        this.roles = roles;
    }
}
