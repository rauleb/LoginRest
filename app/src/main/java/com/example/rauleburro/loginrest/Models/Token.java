package com.example.rauleburro.loginrest.Models;

import com.google.gson.annotations.Expose;

/**
 * Created by rauleburro on 16/11/14.
 */
public class Token {

    @Expose
    private String key;

    /**
     *
     * @return
     * The key
     */
    public String getKey() {
        return key;
    }

    /**
     *
     * @param key
     * The key
     */
    public void setKey(String key) {
        this.key = key;
    }

}
