package com.example.firebase_dssv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;



public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{
    private FirebaseAuth mAuth;
    public EditText email, pass, confirmpass;
    public Button signin, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        confirmpass = (EditText) findViewById(R.id.confirmpass);


        signin = (Button) findViewById(R.id.signInBtn);
        signup = (Button) findViewById(R.id.signUpBtn);
        signup.setOnClickListener(this);
        signin.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signInBtn:
                startActivity(new Intent(this, SignInActivity.class));
                break;
            case R.id.signUpBtn:
                registerUser();
                break;
        }
    }

    private void registerUser() {
        String inputEmail = email.getText().toString().trim();
        String inputPass = pass.getText().toString().trim();
        String confirm = confirmpass.getText().toString().trim();

        if (inputEmail.isEmpty()){
            email.setError("Email is required!");
            email.requestFocus();
            return;
        }
        if (inputPass.isEmpty()){
            pass.setError("Email is required!");
            pass.requestFocus();
            return;
        }
        if (confirm.isEmpty()){
            confirmpass.setError("Email is required!");
            confirmpass.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(inputEmail, inputPass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            User user = new User(inputEmail);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()){
                                                Toast.makeText(SignUpActivity.this, "User has been registered successfully!",Toast.LENGTH_LONG).show();

                                            }
                                            else{
                                                Toast.makeText(SignUpActivity.this, "Failed to register!",Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                        }
                        else {
                            Toast.makeText(SignUpActivity.this, "Failed to register!",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }


}