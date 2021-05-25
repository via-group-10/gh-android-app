package com.example.grinhouseapp.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.ui.main.HomeActivity;
import com.example.grinhouseapp.ui.profile.ProfileViewModel;

public class LoginActivity extends AppCompatActivity {

    LoginViewModel viewModel;

    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewModel =
                new ViewModelProvider(this).get(LoginViewModel.class);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }

    public void performLogin(View v)
    {
        if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty())
            Toast.makeText(this, "All information must be filled", Toast.LENGTH_SHORT).show();
        else
        {
            viewModel.login(username.getText().toString().trim(), password.getText().toString());
            viewModel.getCurrentAccount().observe(this, account -> {
                startActivity(new Intent(this, HomeActivity.class));
                finish();
            });
        }
    }
}