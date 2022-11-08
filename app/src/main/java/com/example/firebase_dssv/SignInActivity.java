package com.example.firebase_dssv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener{
    public Button signIn, signUp;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();



        signIn = findViewById(R.id.signInBtn);
        signUp = findViewById(R.id.signUpBtn);
        signUp.setOnClickListener(this);
        signIn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signUpBtn:
                startActivity(new Intent(this, SignUpActivity.class));
                break;
            case  R.id.signInBtn:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}