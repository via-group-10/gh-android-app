package com.example.grinhouseapp.webservices.graph;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.grinhouseapp.webservices.ServiceGenerator;
import com.example.grinhouseapp.webservices.measurement.MeasurementResponse;
import com.example.grinhouseapp.model.Measurement;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GraphRepository {
    private static GraphRepository instance;
    private final MutableLiveData<List<Measurement>> temperatureMeasurement;
    private final MutableLiveData<List<Measurement>> humidityMeasurement;
    private final MutableLiveData<List<Measurement>> carbonDioxideMeasurement;

    private GraphRepository()
    {
        temperatureMeasurement = new MutableLiveData<>();
        humidityMeasurement = new MutableLiveData<>();
        carbonDioxideMeasurement = new MutableLiveData<>();
    }

    public static synchronized GraphRepository getInstance()
    {
        if(instance == null)
            instance = new GraphRepository();
        return instance;
    }

    public LiveData<List<Measurement>> getTemperatureMeasurement() {
        return temperatureMeasurement;
    }

    public LiveData<List<Measurement>> getHumidityMeasurement() {
        return humidityMeasurement;
    }

    public LiveData<List<Measurement>> getCarbonDioxideMeasurement() {
        return carbonDioxideMeasurement;
    }

    public void setTemperatureMeasurement(String filter)
    {
        GraphApi graphApi = ServiceGenerator.getGraphApi();
        Call<List<MeasurementResponse>> call = graphApi.getTemperatureGraphData(filter);
        call.enqueue(new Callback<List<MeasurementResponse>>() {
            @Override
            public void onResponse(Call<List<MeasurementResponse>> call, Response<List<MeasurementResponse>> response) {
                if(response.isSuccessful() && !response.body().isEmpty())
                {
                    List<MeasurementResponse> measurementResponses = response.body();
                    ArrayList<Measurement> measurements = new ArrayList<>();
                    for (MeasurementResponse measurementResponse : measurementResponses) {
                        measurements.add(measurementResponse.getMeasurement());
                    }
                    temperatureMeasurement.setValue(measurements);
                }
            }

            @Override
            public void onFailure(Call<List<MeasurementResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");
            }
        });
    }

    public void setHumidityMeasurement(String filter)
    {
        GraphApi graphApi = ServiceGenerator.getGraphApi();
        Call<List<MeasurementResponse>> call = graphApi.getTemperatureGraphData(filter);
        call.enqueue(new Callback<List<MeasurementResponse>>() {
            @Override
            public void onResponse(Call<List<MeasurementResponse>> call, Response<List<MeasurementResponse>> response) {
                if(response.isSuccessful() && !response.body().isEmpty())
                {
                    List<MeasurementResponse> measurementResponses = response.body();
                    ArrayList<Measurement> measurements = new ArrayList<>();
                    for (MeasurementResponse measurementResponse : measurementResponses) {
                        measurements.add(measurementResponse.getMeasurement());
                    }
                    try {
                        humidityMeasurement.setValue(measurements);
                    }catch (ArrayIndexOutOfBoundsException e)
                    {

                    }
                }
            }

            @Override
            public void onFailure(Call<List<MeasurementResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");
            }
        });
    }

    public void setCarbonDioxideMeasurement(String filter)
    {
        GraphApi graphApi = ServiceGenerator.getGraphApi();
        Call<List<MeasurementResponse>> call = graphApi.getTemperatureGraphData(filter);
        call.enqueue(new Callback<List<MeasurementResponse>>() {
            @Override
            public void onResponse(Call<List<MeasurementResponse>> call, Response<List<MeasurementResponse>> response) {
                if(response.isSuccessful() && !response.body().isEmpty())
                {
                    List<MeasurementResponse> measurementResponses = response.body();
                    ArrayList<Measurement> measurements = new ArrayList<>();
                    for (MeasurementResponse measurementResponse : measurementResponses) {
                        measurements.add(measurementResponse.getMeasurement());
                    }
                    try {
                        carbonDioxideMeasurement.setValue(measurements);
                    }catch (ArrayIndexOutOfBoundsException e)
                    {

                    }
                }
            }

            @Override
            public void onFailure(Call<List<MeasurementResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");
            }
        });
    }
}
