package com.example.grinhouseapp.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.model.Account;
import com.example.grinhouseapp.webservices.greenhouse.GreenhouseRepository;

public class LoginViewModel extends ViewModel {

    private GreenhouseRepository greenhouseRepository;

    public LoginViewModel()
    {
        greenhouseRepository = GreenhouseRepository.getInstance();
    }

    public void login(String username, String password)
    {
        greenhouseRepository.loginUser(username, password);
    }

    public LiveData<Account> getCurrentAccount()
    {
        return greenhouseRepository.getAccount();
    }
}
