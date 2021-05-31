package com.example.grinhouseapp.webservices.measurement;

import android.util.Log;

import com.example.grinhouseapp.model.Measurement;
import com.example.grinhouseapp.model.MeasurementType;
import com.example.grinhouseapp.webservices.ServiceGenerator;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class MeasurementRepositoryTest extends TestCase {
    private MeasurementRepository measurementRepository;
    private List<Measurement> measurementList;

    @Before
    public void setUp() throws Exception {
        measurementRepository = MeasurementRepository.getInstance();
        measurementList = new ArrayList<>();
    }

    public void testSetTopTemperatureMeasurements() {
        MeasurementApi measurementApi = ServiceGenerator.getMeasurementApi();
        Call<List<MeasurementResponse>> call = measurementApi.getTopTemperatureMeasurements(3);
        call.enqueue(new Callback<List<MeasurementResponse>>() {
            @Override
            public void onResponse(Call<List<MeasurementResponse>> call, Response<List<MeasurementResponse>> response) {
                if(response.isSuccessful() && !response.body().isEmpty())
                {
                    measurementList.clear();
                    List<MeasurementResponse> measurementResponses = response.body();
                    ArrayList<Measurement> measurements = new ArrayList<>();
                    for(MeasurementResponse measurementResponse : measurementResponses)
                    {
                        measurements.add(measurementResponse.getMeasurement());
                    }
                    measurementList.addAll(measurements);
                }
            }

            @Override
            public void onFailure(Call<List<MeasurementResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong", t);
            }
        });

        measurementRepository.setTopTemperatureMeasurements(3);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(measurementList.size(), Objects.requireNonNull(measurementRepository.getTopTemperatureMeasurements().getValue()).size());


    }

    public void testSetTopHumidityMeasurements() {
        MeasurementApi measurementApi = ServiceGenerator.getMeasurementApi();
        Call<List<MeasurementResponse>> call = measurementApi.getTopHumidityMeasurements(1);
        call.enqueue(new Callback<List<MeasurementResponse>>() {
            @Override
            public void onResponse(Call<List<MeasurementResponse>> call, Response<List<MeasurementResponse>> response) {
                if(response.isSuccessful() && !response.body().isEmpty())
                {
                    measurementList.clear();
                    List<MeasurementResponse> measurementResponses = response.body();
                    ArrayList<Measurement> measurements = new ArrayList<>();
                    for(MeasurementResponse measurementResponse : measurementResponses)
                    {
                        measurements.add(measurementResponse.getMeasurement());
                    }
                    measurementList.addAll(measurements);
                }
            }

            @Override
            public void onFailure(Call<List<MeasurementResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong", t);
            }
        });

        measurementRepository.setTopHumidityMeasurements(1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(measurementList.size(),  measurementRepository.getTopHumidityMeasurements().getValue().size());
    }

    public void testSetTopCarbonDioxideMeasurements() {
        MeasurementApi measurementApi = ServiceGenerator.getMeasurementApi();
        Call<List<MeasurementResponse>> call = measurementApi.getTopCarbonDioxideMeasurements(2);
        call.enqueue(new Callback<List<MeasurementResponse>>() {
            @Override
            public void onResponse(Call<List<MeasurementResponse>> call, Response<List<MeasurementResponse>> response) {
                if(response.isSuccessful() && !response.body().isEmpty())
                {
                    List<MeasurementResponse> measurementResponses = response.body();
                    ArrayList<Measurement> measurements = new ArrayList<>();
                    for(MeasurementResponse measurementResponse : measurementResponses)
                    {
                        measurements.add(measurementResponse.getMeasurement());
                    }
                    measurementList.addAll(measurements);
                }
            }

            @Override
            public void onFailure(Call<List<MeasurementResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong", t);
            }
        });

        measurementRepository.setTopCarbonDioxideMeasurements(2);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(measurementList.size(),  Objects.requireNonNull(measurementRepository.getTopCarbonDioxideMeasurements().getValue()).size());


    }

    public void testSetFilterTemperature() {
        Timestamp from = new Timestamp(20210420);
        Timestamp to = new Timestamp(System.currentTimeMillis());
        measurementRepository.setFilterTemperature(from,to);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(measurementRepository.getFilteredTemperatureMeasurementMutableData().getValue());


    }

    public void testSetFilterHumidity() {
        Timestamp from = new Timestamp(20210420);
        Timestamp to = new Timestamp(System.currentTimeMillis());
        measurementRepository.setFilterHumidity(from,to);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(measurementRepository.getFilteredHumidityMeasurementMutableData().getValue());

    }

    public void testSetFilterCarbonDioxide() {
        Timestamp from = new Timestamp(20210420);
        Timestamp to = new Timestamp(System.currentTimeMillis());
        measurementRepository.setFilterCarbonDioxide(from,to);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(measurementRepository.getFilteredCarbonDioxideMeasurementMutableData().getValue());
    }
}