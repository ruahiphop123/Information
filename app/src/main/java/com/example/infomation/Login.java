package com.example.infomation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    Button btLogin;
    TextView tvToRegis;
    List<Account> admin;
    EditText user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        admin = new ArrayList<>();
        admin.add(new Account("ntd","123"));

        user = (EditText) findViewById(R.id.inputUsername);
        pass = (EditText) findViewById(R.id.inputPassword);

//        Intent getData = getIntent();
//        Bundle getDataBundle = getData.getBundleExtra("newAccount");
//        Account newAcc = (Account) getDataBundle.getSerializable("accnew");
//
//        admin.add(newAcc);

        btLogin = (Button) findViewById(R.id.btnLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkPass()){
                    Intent mhInfo = new Intent(Login.this, MainActivity.class);
                    startActivity(mhInfo);
                }
                else{
                    Toast.makeText(Login.this, "Sai tài khoản hoặc mật khẩu!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvToRegis = (TextView) findViewById(R.id.tvToRegis);
        tvToRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mhRegis = new Intent(Login.this,Register.class);
                startActivity(mhRegis);
            }
        });
    }
    public boolean checkPass(){
        boolean check = false;
        for (Account x : admin)
        {
            String userCheck = x.getTaiKhoan();
            String passCheck = x.getMatKhau();
            if (userCheck.equals(user.getText().toString()) && passCheck.equals(pass.getText().toString())){
                check = true;
                break;
            }
        }
        return check;
    }
}