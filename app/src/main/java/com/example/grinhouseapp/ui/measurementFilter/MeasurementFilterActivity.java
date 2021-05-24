package com.example.grinhouseapp.ui.measurementFilter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.model.Measurement;
import com.example.grinhouseapp.model.MeasurementType;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class MeasurementFilterActivity extends AppCompatActivity  {

    private Button datePickerBtn;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private MeasurementFilterViewModel viewModel;
    private ArrayList<Measurement> filterList = new ArrayList<>();
    private RadioButton co2, humidity, temperature;
    MaterialDatePicker materialDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_filter);

        viewModel = new ViewModelProvider(this).get(MeasurementFilterViewModel.class);

        co2 = findViewById(R.id.radioCO2);
        humidity = findViewById(R.id.radioHumidity);
        temperature = findViewById(R.id.radioTemperature);

        datePickerBtn = findViewById(R.id.date_picker_btn);
        recyclerView = findViewById(R.id.filterRecView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);

        adapter = new MeasurementFilterAdapter(filterList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        //MaterialDatePicker
        MaterialDatePicker.Builder<Pair<Long,Long>> builder = MaterialDatePicker.Builder.dateRangePicker();
        materialDatePicker = builder.build();

        datePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Pair<Long,Long>>() {
            @Override
            public void onPositiveButtonClick(Pair<Long,Long> selection) {

               Log.i("Date picker", selection.first + " ...." + selection.second);
               filterList.clear();
               listenerOnCheckboxClick(selection.first, selection.second);
            }
        });

    }


    public void listenerOnCheckboxClick(long from, long to){

        if (co2.isChecked()){
            viewModel.setMeasurementRepository(MeasurementType.carbonDioxide, new Timestamp(from),new Timestamp(to));
            viewModel.getCarbonDioxideFilterMeasurement().observe(this, measurements -> {
                filterList.clear();
                filterList.addAll(measurements);
                adapter.notifyDataSetChanged();
            });
        } else if (humidity.isChecked()){
            viewModel.setMeasurementRepository(MeasurementType.humidity, new Timestamp(from),new Timestamp(to));
            viewModel.getHumidityFilterMeasurement().observe(this, measurements -> {
                filterList.clear();
                filterList.addAll(measurements);
                adapter.notifyDataSetChanged();
            });
        }

        else {
            viewModel.setMeasurementRepository(MeasurementType.temperature, new Timestamp(from),new Timestamp(to));
            viewModel.getTemperatureFilterMeasurement().observe(this, measurements -> {
                filterList.clear();
                filterList.addAll(measurements);
                adapter.notifyDataSetChanged();
            });
        }
    }




}