package com.example.grinhouseapp.ui.filter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.util.Pair;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.model.Measurement;
import com.example.grinhouseapp.model.MeasurementType;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FilterActivity extends AppCompatActivity  {

    private Button datePickerBtn, searchButton;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private FilterViewModel viewModel;
    private ArrayList<Measurement> filterList;
    private RadioButton co2, humidity, temperature;
    private TextView date_picker_text;
    MaterialDatePicker materialDatePicker;

    private Long dateFromL, dateToL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        viewModel = new ViewModelProvider(this).get(FilterViewModel.class);

        co2 = findViewById(R.id.radioCO2);
        humidity = findViewById(R.id.radioHumidity);
        temperature = findViewById(R.id.radioTemperature);
        date_picker_text = findViewById(R.id.date_picker_text);
        searchButton = findViewById(R.id.searchButton);

        datePickerBtn = findViewById(R.id.date_picker_btn);
        recyclerView = findViewById(R.id.filterRecView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);

        filterList = new ArrayList<>();

        adapter = new FilterAdapter(filterList);
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
                dateFromL = selection.first;
                dateToL = selection.second;
                Log.i("Date picker", selection.first + " ...." + selection.second);
                Date dateFrom = new Date(dateFromL);
                Date dateTo = new Date(dateToL);
                date_picker_text.setText(new SimpleDateFormat("dd/MM/yyyy").format(dateFrom)
                       + " - " +
                        new SimpleDateFormat("dd/MM/yyyy").format(dateTo));
            }
        });

        searchButton.setOnClickListener(v -> {
            try {
                listenerOnCheckboxClick(dateFromL, dateToL);
            }catch (NullPointerException e){
                Toast.makeText(this, "You need to set date first!", Toast.LENGTH_SHORT).show();
            }
            filterList.clear();
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