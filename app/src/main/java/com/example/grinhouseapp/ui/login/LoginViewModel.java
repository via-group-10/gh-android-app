package com.example.grinhouseapp.ui.login;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.grinhouseapp.database.DatabaseRepository;
import com.example.grinhouseapp.model.Account;
import com.example.grinhouseapp.webservices.greenhouse.GreenhouseRepository;

public class LoginViewModel extends AndroidViewModel {

    private GreenhouseRepository greenhouseRepository;
    private DatabaseRepository databaseRepository;

    public LoginViewModel(Application app)
    {
        super(app);
        greenhouseRepository = GreenhouseRepository.getInstance();
        databaseRepository = DatabaseRepository.getInstance(app);
    }

    public void login(String username, String password)
    {
        greenhouseRepository.loginUser(username, password);
    }

    public LiveData<Account> getCurrentAccount()
    {
        return greenhouseRepository.getAccount();
    }

    public LiveData<Account> getAccount(String username, String password)
    {
        return databaseRepository.getAccount(username, password);
    }

    public void replaceAccount(Account account)
    {
        databaseRepository.insertAccount(account);
    }
}
