package com.vaibhavs.stormhacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    EditText email,password;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton();
        registerButton();
    }

    private void registerButton() {
        TextView register = (TextView) findViewById(R.id.register_btn);

        register.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this, RegisterPage.class );
                startActivity(i);
            }
        });
    }

    void loginButton(){

        email = (EditText) findViewById(R.id.email_txt);
        password = (EditText) findViewById(R.id.password_txt);
        FloatingActionButton login = findViewById(R.id.floatingActionButton);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter the Data", Toast.LENGTH_SHORT).show();
                }else{
                    Intent i = new Intent(MainActivity.this, main_menu.class );
                    startActivity(i);
                }
            }
        });
    }
}
