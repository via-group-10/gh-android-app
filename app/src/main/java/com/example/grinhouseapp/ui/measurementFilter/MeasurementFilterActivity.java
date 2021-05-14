package com.example.grinhouseapp.ui.measurementFilter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.model.Measurement;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.util.ArrayList;

public class MeasurementFilterActivity extends AppCompatActivity {

    private Button datePickerBtn;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private MeasurementFilterViewModel viewModel;
    private ArrayList<Measurement> filterList;

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
        MaterialDatePicker materialDatePicker = builder.build();

        datePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
            }
        });

    }
}