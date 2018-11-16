package com.reviews.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.reviews.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt_signUp;
    EditText et_email, et_password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        initializeUI();
        initializeValues();

    }

    private void initializeUI() {
        //TextView
        txt_signUp = findViewById(R.id.txt_signUp);
        //EditText
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        //Button
        btn_login = findViewById(R.id.btn_login);

    }

    private void initializeValues() {
        btn_login.setOnClickListener(this);
        txt_signUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.txt_signUp:
                intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_login:
                intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("Activity", getIntent().getStringExtra("Activity"));
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("Activity", getIntent().getStringExtra("Activity"));
        startActivity(intent);
    }
}
