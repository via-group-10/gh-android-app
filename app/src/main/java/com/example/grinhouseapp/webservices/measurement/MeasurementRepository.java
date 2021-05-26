package com.example.grinhouseapp.webservices.measurement;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.grinhouseapp.webservices.ServiceGenerator;
import com.example.grinhouseapp.model.Measurement;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class MeasurementRepository {
    private static MeasurementRepository instance;
    private final MutableLiveData<List<Measurement>> latestMeasurementsMutableData;

    private final MutableLiveData<List<Measurement>> topTemperatureMeasurements;
    private final MutableLiveData<List<Measurement>> topHumidityMeasurements;
    private final MutableLiveData<List<Measurement>> topCarbonDioxideMeasurements;

    private final MutableLiveData<List<Measurement>> filteredTemperatureMeasurementMutableData;
    private final MutableLiveData<List<Measurement>> filteredCarbonDioxideMeasurementMutableData;
    private final MutableLiveData<List<Measurement>> filteredHumidityMeasurementMutableData;

    private MeasurementRepository()
    {
        latestMeasurementsMutableData = new MutableLiveData<>();

        topTemperatureMeasurements = new MutableLiveData<>();
        topHumidityMeasurements = new MutableLiveData<>();
        topCarbonDioxideMeasurements = new MutableLiveData<>();

        filteredHumidityMeasurementMutableData = new MutableLiveData<>();
        filteredCarbonDioxideMeasurementMutableData = new MutableLiveData<>();
        filteredTemperatureMeasurementMutableData = new MutableLiveData<>();
    }

    public static synchronized MeasurementRepository getInstance()
    {
        if(instance == null)
            instance = new MeasurementRepository();
        return instance;
    }

    public LiveData<List<Measurement>> getLatestMeasurements() {
        return  latestMeasurementsMutableData;
    }

    public LiveData<List<Measurement>> getTopTemperatureMeasurements()
    {
        return topTemperatureMeasurements;
    }

    public LiveData<List<Measurement>> getTopHumidityMeasurements()
    {
        return topHumidityMeasurements;
    }

    public LiveData<List<Measurement>> getTopCarbonDioxideMeasurements()
    {
        return topCarbonDioxideMeasurements;
    }

    public LiveData<List<Measurement>> getFilteredTemperatureMeasurementMutableData() {
        return filteredTemperatureMeasurementMutableData;
    }

    public LiveData<List<Measurement>> getFilteredCarbonDioxideMeasurementMutableData() {
        return filteredCarbonDioxideMeasurementMutableData;
    }

    public LiveData<List<Measurement>> getFilteredHumidityMeasurementMutableData() {
        return filteredHumidityMeasurementMutableData;
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

    public void setTopTemperatureMeasurements(int count)
    {
        MeasurementApi measurementApi = ServiceGenerator.getMeasurementApi();
        Call<List<MeasurementResponse>> call = measurementApi.getTopTemperatureMeasurements(count);
        call.enqueue(new Callback<List<MeasurementResponse>>() {
            @Override
            public void onResponse(Call<List<MeasurementResponse>> call, Response<List<MeasurementResponse>> response) {
                if(response.isSuccessful())
                {
                    List<MeasurementResponse> measurementResponses = response.body();
                    ArrayList<Measurement> measurements = new ArrayList<>();
                    for(MeasurementResponse measurementResponse : measurementResponses)
                    {
                        measurements.add(measurementResponse.getMeasurement());
                    }
                    topTemperatureMeasurements.setValue(measurements);
                }
            }

            @Override
            public void onFailure(Call<List<MeasurementResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong", t);
            }
        });
    }

    public void setTopHumidityMeasurements(int count)
    {
        MeasurementApi measurementApi = ServiceGenerator.getMeasurementApi();
        Call<List<MeasurementResponse>> call = measurementApi.getTopHumidityMeasurements(count);
        call.enqueue(new Callback<List<MeasurementResponse>>() {
            @Override
            public void onResponse(Call<List<MeasurementResponse>> call, Response<List<MeasurementResponse>> response) {
                if(response.isSuccessful())
                {
                    List<MeasurementResponse> measurementResponses = response.body();
                    ArrayList<Measurement> measurements = new ArrayList<>();
                    for(MeasurementResponse measurementResponse : measurementResponses)
                    {
                        measurements.add(measurementResponse.getMeasurement());
                    }
                    topHumidityMeasurements.setValue(measurements);
                }
            }

            @Override
            public void onFailure(Call<List<MeasurementResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong", t);
            }
        });
    }

    public void setTopCarbonDioxideMeasurements(int count)
    {
        MeasurementApi measurementApi = ServiceGenerator.getMeasurementApi();
        Call<List<MeasurementResponse>> call = measurementApi.getTopCarbonDioxideMeasurements(count);
        call.enqueue(new Callback<List<MeasurementResponse>>() {
            @Override
            public void onResponse(Call<List<MeasurementResponse>> call, Response<List<MeasurementResponse>> response) {
                if(response.isSuccessful())
                {
                    List<MeasurementResponse> measurementResponses = response.body();
                    ArrayList<Measurement> measurements = new ArrayList<>();
                    for(MeasurementResponse measurementResponse : measurementResponses)
                    {
                        measurements.add(measurementResponse.getMeasurement());
                    }
                    topCarbonDioxideMeasurements.setValue(measurements);
                }
            }

            @Override
            public void onFailure(Call<List<MeasurementResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong", t);
            }
        });
    }

    public void setFilterTemperature(Timestamp from, Timestamp to)
    {
        MeasurementApi measurementApi = ServiceGenerator.getMeasurementApi();
        Call<List<MeasurementResponse>> call = measurementApi.getFilteredTemperature(from, to);
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
                    filteredTemperatureMeasurementMutableData.setValue(measurements);
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<List<MeasurementResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong", t);
            }
        });
    }

    public void setFilterHumidity(Timestamp from, Timestamp to)
    {
        MeasurementApi measurementApi = ServiceGenerator.getMeasurementApi();
        Call<List<MeasurementResponse>> call = measurementApi.getFilteredHumidity(from, to);
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
                    filteredHumidityMeasurementMutableData.setValue(measurements);
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<List<MeasurementResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong", t);
            }
        });
    }

    public void setFilterCarbonDioxide(Timestamp from, Timestamp to)
    {
        MeasurementApi measurementApi = ServiceGenerator.getMeasurementApi();
        Call<List<MeasurementResponse>> call = measurementApi.getFilteredCarbonDioxide(from, to);
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
                    filteredCarbonDioxideMeasurementMutableData.setValue(measurements);
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
