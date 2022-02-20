package com.vaibhavs.stormhacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class Addcontact extends AppCompatActivity {

    private static final String EXTRA_NAME = "PERSONNAME";
    private static final String EXTRA_IMG = "IMAGE";
    private static final String EXTRA_EMAIL = "EMAIL";
    private static final String EXTRA_NUM = "NUMBER";

    private String personName;
    private int img;
    private String email;
    private String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontact);
        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        personName = intent.getStringExtra(EXTRA_NAME);
        img = intent.getIntExtra(EXTRA_IMG, 0);
        email = intent.getStringExtra(EXTRA_EMAIL);
        number = intent.getStringExtra(EXTRA_NUM);
    }

    public static Intent makeIntent(Context context, String personName, int image,String email, String number){
        Intent intent = new Intent(context, Addcontact.class);
        intent.putExtra("PERSONNAME", personName);
        intent.putExtra("IMAGE", image);
        intent.putExtra("EMAIL", email);
        intent.putExtra("NUMBER", number);
        return intent;
    }
}