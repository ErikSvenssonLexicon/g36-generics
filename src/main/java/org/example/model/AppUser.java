package org.example.model;

import java.util.Objects;

public class AppUser {

    private Integer appUserId;
    private String username;
    private String password;
    private Person userDetails;

    public AppUser(Integer appUserId, String username, String password, Person userDetails) {
        this.appUserId = appUserId;
        this.username = username;
        this.password = password;
        this.userDetails = userDetails;
    }

    public Integer getAppUserId() {
        return appUserId;
    }

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

    public Person getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(Person userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(getAppUserId(), appUser.getAppUserId()) && Objects.equals(getUsername(), appUser.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAppUserId(), getUsername());
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "appUserId=" + appUserId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
