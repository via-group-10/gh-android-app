package com.example.grinhouseapp.database;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.grinhouseapp.model.Account;
import com.example.grinhouseapp.model.Measurement;
import com.example.grinhouseapp.model.MeasurementType;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseRepository {
    private static DatabaseRepository instance;

    private final AccountsDAO accountsDAO;
    private final MeasurementsDAO measurementsDAO;

    private final ExecutorService executorService;

    private LiveData<Account> accountLiveData;
    private LiveData<List<Measurement>> measurementsLiveData;

    private DatabaseRepository(Application app)
    {
        GrinhouseDatabase database = GrinhouseDatabase.getInstance(app);
        accountsDAO = database.accountsDAO();
        measurementsDAO = database.measurementsDAO();
        executorService = Executors.newFixedThreadPool(2);
    }

    public static synchronized DatabaseRepository getInstance(Application app)
    {
        if(instance == null)
            instance = new DatabaseRepository(app);
        return instance;
    }

    public LiveData<Account> getAccount(String username, String password)
    {
        accountLiveData = accountsDAO.getAccount(username, password);
        return accountLiveData;
    }

    public void insertAccount(Account account)
    {
        executorService.execute(() -> accountsDAO.insert(account));
    }

    public void insertMeasurement(List<Measurement> measurements)
    {
        executorService.execute(() -> measurementsDAO.insert(measurements));
    }

    public LiveData<List<Measurement>> getAllMeasurements(MeasurementType measurementType)
    {
        measurementsLiveData = measurementsDAO.getAllTypeMeasurements(measurementType);
        return measurementsLiveData;
    }
}
