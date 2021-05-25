package com.example.grinhouseapp.webservices.greenhouse;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.grinhouseapp.model.Account;
import com.example.grinhouseapp.model.Credentials;
import com.example.grinhouseapp.webservices.ServiceGenerator;

import okio.Buffer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GreenhouseRepository {
    private static GreenhouseRepository instance;
    private final MutableLiveData<Account> currentAccount;

    private GreenhouseRepository()
    {
        currentAccount = new MutableLiveData<>();
    }

    public static synchronized GreenhouseRepository getInstance()
    {
        if(instance == null)
            instance = new GreenhouseRepository();
        return instance;
    }

    public void loginUser(String username, String password)
    {
        GreenhouseApi greenhouseApi = ServiceGenerator.getGreenhouseApi();
        Credentials credentials = new Credentials(username, password);
        Call<GreenhouseResponse> call = greenhouseApi.login(credentials);
        call.enqueue(new Callback<GreenhouseResponse>() {
            @Override
            public void onResponse(Call<GreenhouseResponse> call, Response<GreenhouseResponse> response) {
                if(response.isSuccessful())
                {
                    currentAccount.setValue(response.body().getAccount());
                }
            }

            @Override
            public void onFailure(Call<GreenhouseResponse> call, Throwable t) {
                Log.i("Retrofit", "Could not log in");
            }
        });
    }

    public LiveData<Account> getAccount()
    {
        return currentAccount;
    }
}
