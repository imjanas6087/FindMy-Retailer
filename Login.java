package com.example.findmyretailer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends AppCompatActivity {
    private EditText email, password;
    private Button button;
    private SharedPreferences sharedPreferences;
    String TAG_KEY = "CREDENTIALS";
    public static final String mEmail = "Email";
    public static final String mPassword = "Password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.email);
        password= (EditText) findViewById(R.id.password);
        sharedPreferences = getSharedPreferences(TAG_KEY,MODE_PRIVATE);
        button = (Button) findViewById(R.id.login);
        String mE = email.getText().toString();
        String mP = password.getText().toString();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkMethod(mE, mP);
            }
        });

    }

    private void checkMethod(String Email, String Password) {

        if(Email!=null && Password!=null){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(mEmail,Email);
            editor.putString(mPassword,Password);
            editor.commit();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Credentials Saved Successfully", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        String email =sharedPreferences.getString(mEmail,null);
        String password =sharedPreferences.getString(mEmail,null);
        if(email!=null && password != null){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }
}