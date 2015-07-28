package com.example.rauleburro.loginrest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.rauleburro.loginrest.Api.tutoRest;
import com.example.rauleburro.loginrest.Models.Token;
import com.example.rauleburro.loginrest.Models.Usuario;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;

import java.util.Date;
import java.util.concurrent.Callable;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;


public class repuestaToken extends Activity {

    Token token;
    TextView tokenView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repuesta_token);

        Bundle bundle = getIntent().getExtras();

        tokenView = (TextView)findViewById(R.id.token);

        final Usuario user = new Usuario();

        user.setUsername(bundle.getString("usuario"));
        System.out.println("Usuario: "+user.getUsername());
        user.setPassword(bundle.getString("password"));
        System.out.println("Contraseña: "+user.getPassword());
        /*Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                .registerTypeAdapter(Date.class,new DateTypeAdapter())
                .create();*/

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://infoparaguay.tk/")
                //.setConverter(new GsonConverter(gson))
                .build();

        final tutoRest tuto = adapter.create(tutoRest.class);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                tuto.getToken(user,new Callback<Token>() {
                    @Override
                    public void success(Token tok, Response response) {
                        token = tok;
                        System.out.println(response.getBody().toString());
                        updateGui();
                    }

                    @Override
                    public void failure(RetrofitError retrofitError) {
                        retrofitError.printStackTrace();
                        token = new Token();
                                token.setKey("Usuario y/o contraseña erronea");
                        updateGui();
                    }
                });
            }
        });
        t.start();

    }

    private void updateGui() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tokenView.setText(token.getKey().toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_repuesta_token, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
