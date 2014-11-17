package com.example.rauleburro.loginrest.Api;

import com.example.rauleburro.loginrest.Models.Token;
import com.example.rauleburro.loginrest.Models.Usuario;

import java.util.concurrent.Callable;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Headers;
import retrofit.http.POST;

/**
 * Created by rauleburro on 16/11/14.
 */
public interface tutoRest {

    @Headers({
            "Accept: application/json",
            "Cache-Control: no-cache",
            "Content-Type: application/json"
    })
    //@FormUrlEncoded
    @POST("/token-auth/")
    //Token getToken(@Body Usuario usuario);
    void getToken(@Body Usuario usuario, Callback<Token> response);
}
