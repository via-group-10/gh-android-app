package com.example.grinhouseapp.webservices;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class MeasurementRepository {
    private static MeasurementRepository instance;
    private final MutableLiveData<List<Measurement>> allMeasurementsMutableData;
    private final MutableLiveData<List<Measurement>> latestMeasurementsMutableData;
    private final MutableLiveData<List<Measurement>> temperatureMeasurementMutableData;
    private final MutableLiveData<List<Measurement>> humidityMeasurementMutableData;
    private final MutableLiveData<List<Measurement>> carbonDioxideMeasurementMutableData;

    private MeasurementRepository()
    {
        allMeasurementsMutableData = new MutableLiveData<>();
        latestMeasurementsMutableData = new MutableLiveData<>();
        temperatureMeasurementMutableData = new MutableLiveData<>();
        humidityMeasurementMutableData = new MutableLiveData<>();
        carbonDioxideMeasurementMutableData = new MutableLiveData<>();
    }

    public static synchronized MeasurementRepository getInstance()
    {
        if(instance == null)
            instance = new MeasurementRepository();
        return instance;
    }

    public LiveData<List<Measurement>> getAllMeasurements()
    {
        return allMeasurementsMutableData;
    }

    public LiveData<List<Measurement>> getLatestMeasurements() {
        return  latestMeasurementsMutableData;
    }

    public LiveData<List<Measurement>> getTemperatureMeasurementMutableData() {
        return temperatureMeasurementMutableData;
    }

    public LiveData<List<Measurement>> getHumidityMeasurementMutableData() {
        return humidityMeasurementMutableData;
    }

    public LiveData<List<Measurement>> getCarbonDioxideMeasurementMutableData() {
        return carbonDioxideMeasurementMutableData;
    }

    public void setAllMeasurements()
    {
        MeasurementApi measurementApi = ServiceGenerator.getMeasurementApi();
        Call<List<MeasurementResponse>> call = measurementApi.getAllMeasurements();
        call.enqueue(new Callback<List<MeasurementResponse>>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<List<MeasurementResponse>> call, Response<List<MeasurementResponse>> response) {
                if(response.isSuccessful()) {
                    List<MeasurementResponse> measurementResponses = response.body();
                    ArrayList<Measurement> measurements = new ArrayList<>();
                    for (MeasurementResponse measurementResponse : measurementResponses) {
                        measurements.add(measurementResponse.getMeasurement());
                    }
                    allMeasurementsMutableData.setValue(measurements);
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<List<MeasurementResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong", t);
            }
        });
    }

    public void setLatestMeasurements()
    {
        MeasurementApi measurementApi = ServiceGenerator.getMeasurementApi();
        Call<List<MeasurementResponse>> call = measurementApi.getLatestMeasurements();
        call.enqueue(new Callback<List<MeasurementResponse>>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<List<MeasurementResponse>> call, Response<List<MeasurementResponse>> response) {
                if(response.isSuccessful()) {

                    List<MeasurementResponse> measurementResponses = response.body();
                    ArrayList<Measurement> measurements = new ArrayList<>();
                    for (MeasurementResponse measurementResponse : measurementResponses) {
                        measurements.add(measurementResponse.getMeasurement());
                    }
                    latestMeasurementsMutableData.setValue(measurements);
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<List<MeasurementResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong", t);
            }
        });
    }

    public void setTemperatureMeasurements()
    {
        MeasurementApi measurementApi = ServiceGenerator.getMeasurementApi();
        Call<List<MeasurementResponse>> call = measurementApi.getTemperatureMeasurement();
        call.enqueue(new Callback<List<MeasurementResponse>>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<List<MeasurementResponse>> call, Response<List<MeasurementResponse>> response) {
                if(response.isSuccessful()) {

                    ArrayList<MeasurementResponse> measurementResponses = new ArrayList<MeasurementResponse>(response.body());
                    ArrayList<Measurement> measurements = new ArrayList<>();
                    for (MeasurementResponse measurementResponse : measurementResponses) {
                        measurements.add(measurementResponse.getMeasurement());
                    }
                    temperatureMeasurementMutableData.setValue(measurements);
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<List<MeasurementResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong", t);
            }
        });
    }

    public void setHumidityMeasurements()
    {
        MeasurementApi measurementApi = ServiceGenerator.getMeasurementApi();
        Call<List<MeasurementResponse>> call = measurementApi.getHumidityMeasurement();
        call.enqueue(new Callback<List<MeasurementResponse>>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<List<MeasurementResponse>> call, Response<List<MeasurementResponse>> response) {
                if(response.isSuccessful()) {

                    ArrayList<MeasurementResponse> measurementResponses = new ArrayList<MeasurementResponse>(response.body());
                    ArrayList<Measurement> measurements = new ArrayList<>();
                    for (MeasurementResponse measurementResponse : measurementResponses) {
                        measurements.add(measurementResponse.getMeasurement());
                    }
                    humidityMeasurementMutableData.setValue(measurements);
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<List<MeasurementResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong", t);
            }
        });
    }

    public void setCarbonDioxideMeasurement()
    {
        MeasurementApi measurementApi = ServiceGenerator.getMeasurementApi();
        Call<List<MeasurementResponse>> call = measurementApi.getCarbonDioxideMeasurement();
        call.enqueue(new Callback<List<MeasurementResponse>>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<List<MeasurementResponse>> call, Response<List<MeasurementResponse>> response) {
                if(response.isSuccessful()) {

                    ArrayList<MeasurementResponse> measurementResponses = new ArrayList<MeasurementResponse>(response.body());
                    ArrayList<Measurement> measurements = new ArrayList<>();
                    for (MeasurementResponse measurementResponse : measurementResponses) {
                        measurements.add(measurementResponse.getMeasurement());
                    }
                    carbonDioxideMeasurementMutableData.setValue(measurements);
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<List<MeasurementResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong", t);
            }
        });
    }
}
