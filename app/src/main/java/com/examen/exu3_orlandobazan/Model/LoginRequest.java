package com.examen.exu3_orlandobazan.Model;

public class LoginRequest {
    private String username;
    private String password;

    public LoginRequest(String dni, String password) {
        this.username = dni;
        this.password = password;
    }

    public String getDni() {
        return username;
    }

    public void setDni(String dni) {
        this.username = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
