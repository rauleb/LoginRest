package com.example.rauleburro.loginrest.Models;


import com.google.gson.annotations.Expose;

/**
 * Created by rauleburro on 16/11/14.
 */

public class Usuario {

    @Expose
    private String username;
    @Expose
    private String password;

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     * The password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     * The password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}