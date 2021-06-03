package ua.aleksandr.hotelproject.bean;

import java.util.Objects;

public class LoginData {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginData loginData = (LoginData) o;
        return Objects.equals(username, loginData.username) &&
                Objects.equals(password, loginData.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
