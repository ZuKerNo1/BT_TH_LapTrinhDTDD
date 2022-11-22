package com.example.baiktra2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private static final String FILE_EMAIL = "rememberMe";
    private EditText emailEdit, passEdit;
    private Button loginBtn, registerBtn;
    private FirebaseAuth mAuth;
    private CheckBox rememberMe;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        emailEdit = findViewById(R.id.email);
        passEdit = findViewById(R.id.password);
        loginBtn = findViewById(R.id.signInBtn);
        registerBtn = findViewById(R.id.signUpBtn);
        rememberMe = findViewById(R.id.rememberMe);

        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        //lay gia tri
        emailEdit.setText(sharedPreferences.getString("taikhoan", ""));
        passEdit.setText(sharedPreferences.getString("matkhau", ""));
        rememberMe.setChecked(sharedPreferences.getBoolean("checked", false));

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

        //Remember Me

    }

    private void register() {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }

    private void login() {
        String email, pass;
        email = emailEdit.getText().toString();
        pass = passEdit.getText().toString();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"Vui lòng nhập email!", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Vui lòng nhập mật khẩu!", Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    if (rememberMe.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan", email);
                        editor.putString("matkhau", pass);
                        editor.putBoolean("checked", true);
                        editor.commit();
                    }else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Đăng nhập thất bại!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}