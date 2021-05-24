package com.example.grinhouseapp.ui.measurementFilter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.model.Measurement;
import com.example.grinhouseapp.model.MeasurementType;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MeasurementFilterActivity extends AppCompatActivity  {

    private Button datePickerBtn;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private MeasurementFilterViewModel viewModel;
    private ArrayList<Measurement> filterList;
    private CheckBox co2, humidity, temperature;
    MaterialDatePicker materialDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_filter);

        viewModel = new ViewModelProvider(this).get(MeasurementFilterViewModel.class);

        datePickerBtn = findViewById(R.id.date_picker_btn);
        recyclerView = findViewById(R.id.filterRecView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);

        filterList = new ArrayList<>();
        filterList.add(new Measurement());

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

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {

               Log.i("Date picker", materialDatePicker.getHeaderText());
               listenerOnCheckboxClick();
            }
        });

    }


    public void listenerOnCheckboxClick(){
        co2 = findViewById(R.id.checkboxCO2);
        humidity = findViewById(R.id.checkboxHumidity);
        temperature = findViewById(R.id.checkboxTemperature);

        if (co2.isChecked()){
            viewModel.setMeasurementRepository(MeasurementType.carbonDioxide, Timestamp.valueOf(materialDatePicker.getHeaderText()),Timestamp.valueOf(materialDatePicker.getHeaderText()));
            viewModel.getCarbonDioxideFilterMeasurement();
        }

        if (humidity.isChecked()){
            viewModel.setMeasurementRepository(MeasurementType.humidity, Timestamp.valueOf(materialDatePicker.getHeaderText()),Timestamp.valueOf(materialDatePicker.getHeaderText()));
            viewModel.getHumidityFilterMeasurement();

        }

        if (temperature.isChecked()){
            viewModel.setMeasurementRepository(MeasurementType.temperature, Timestamp.valueOf(materialDatePicker.getHeaderText()),Timestamp.valueOf(materialDatePicker.getHeaderText()));
            viewModel.getTemperatureFilterMeasurement();
        }
    }
}