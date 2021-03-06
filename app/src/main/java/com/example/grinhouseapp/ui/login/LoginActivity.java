package com.example.grinhouseapp.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.grinhouseapp.NetworkCheck;
import com.example.grinhouseapp.R;
import com.example.grinhouseapp.ui.main.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    LoginViewModel viewModel;

    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(LoginViewModel.class);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }

    public void performLogin(View v) {
        if (NetworkCheck.isInternetAvailable(this)) {
            if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty())
                Toast.makeText(this, "All information must be filled", Toast.LENGTH_SHORT).show();
            else {
                viewModel.login(username.getText().toString().trim(), password.getText().toString());
                viewModel.getCurrentAccount().observe(this, account -> {
                    if(username.getText().toString().trim().equals(account.getLoginName()) && password.getText().toString().equals(account.getLoginPassword())) {
                        Log.i("Credentials", account.toString());
                        viewModel.replaceAccount(account);
                        startActivity(new Intent(this, HomeActivity.class));
                        finish();
                    }
                    else{
                        Toast.makeText(this, "User not found.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        } else {
            if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty())
                Toast.makeText(this, "All information must be filled", Toast.LENGTH_SHORT).show();
            else {
                viewModel.getAccount(username.getText().toString(), password.getText().toString()).observe(this, account -> {
                    if(account != null && username.getText().toString().trim().equals(account.getLoginName()) && password.getText().toString().equals(account.getLoginPassword())) {
                        Toast.makeText(this, "No available network connection. Data will not be updated.", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(this, HomeActivity.class));
                        finish();
                    }
                    else{
                        Toast.makeText(this, "User not found.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }
}
