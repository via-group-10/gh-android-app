package com.example.grinhouseapp.architecture.graph;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.grinhouseapp.architecture.ServiceGenerator;
import com.example.grinhouseapp.architecture.measurement.MeasurementResponse;
import com.example.grinhouseapp.model.Measurement;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GraphRepository {
    private static GraphRepository instance;
    private final MutableLiveData<Measurement> temperatureMeasurement;
    private final MutableLiveData<Measurement> humidityMeasurement;
    private final MutableLiveData<Measurement> carbonDioxideMeasurement;

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

    public LiveData<Measurement> getTemperatureMeasurement() {
        return temperatureMeasurement;
    }

    public LiveData<Measurement> getHumidityMeasurement() {
        return humidityMeasurement;
    }

    public LiveData<Measurement> getCarbonDioxideMeasurement() {
        return carbonDioxideMeasurement;
    }

    public void setTemperatureMeasurement(String filter)
    {
        GraphApi graphApi = ServiceGenerator.getGraphApi();
        Call<MeasurementResponse> call = graphApi.getTemperatureGraphData(filter);
        call.enqueue(new Callback<MeasurementResponse>() {
            @Override
            public void onResponse(Call<MeasurementResponse> call, Response<MeasurementResponse> response) {
                if(response.isSuccessful())
                    temperatureMeasurement.setValue(response.body().getMeasurement());
            }

            @Override
            public void onFailure(Call<MeasurementResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");
            }
        });
    }

    public void setHumidityMeasurement(String filter)
    {
        GraphApi graphApi = ServiceGenerator.getGraphApi();
        Call<MeasurementResponse> call = graphApi.getHumidityGraphData(filter);
        call.enqueue(new Callback<MeasurementResponse>() {
            @Override
            public void onResponse(Call<MeasurementResponse> call, Response<MeasurementResponse> response) {
                if(response.isSuccessful())
                    humidityMeasurement.setValue(response.body().getMeasurement());
            }

            @Override
            public void onFailure(Call<MeasurementResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");
            }
        });
    }

    public void setCarbonDioxideMeasurement(String filter)
    {
        GraphApi graphApi = ServiceGenerator.getGraphApi();
        Call<MeasurementResponse> call = graphApi.getCarbonDioxideGraphData(filter);
        call.enqueue(new Callback<MeasurementResponse>() {
            @Override
            public void onResponse(Call<MeasurementResponse> call, Response<MeasurementResponse> response) {
                if(response.isSuccessful())
                    carbonDioxideMeasurement.setValue(response.body().getMeasurement());
            }

            @Override
            public void onFailure(Call<MeasurementResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");
            }
        });
    }
}
