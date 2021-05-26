package com.example.grinhouseapp.ui.filter;

import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.model.Measurement;
import com.example.grinhouseapp.model.MeasurementType;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FilterFragment extends Fragment {

    private Button datePickerBtn, searchButton;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private FilterViewModel viewModel;
    private ArrayList<Measurement> filterList;
    private RadioButton co2, humidity, temperature;
    private TextView date_picker_text;
    MaterialDatePicker materialDatePicker;
    BottomNavigationView bottomNavigationView;
    private Long dateFromL, dateToL;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter,container, false);

        viewModel = new ViewModelProvider(this).get(FilterViewModel.class);
        bottomNavigationView = getActivity().findViewById(R.id.nav_view);
        bottomNavigationView.setVisibility(View.INVISIBLE);

        co2 = view.findViewById(R.id.radioCO2);
        humidity = view.findViewById(R.id.radioHumidity);
        temperature = view.findViewById(R.id.radioTemperature);
        date_picker_text = view.findViewById(R.id.date_picker_text);
        searchButton = view.findViewById(R.id.searchButton);

        datePickerBtn = view.findViewById(R.id.date_picker_btn);
        recyclerView = view.findViewById(R.id.filterRecView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());

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
                materialDatePicker.show(getActivity().getSupportFragmentManager(), "DATE_PICKER");
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
                Toast.makeText(getActivity(), "You need to set date first!", Toast.LENGTH_SHORT).show();
            }
            filterList.clear();
        });

        return view;
    }




    public void listenerOnCheckboxClick(long from, long to){

        if (co2.isChecked()){
            viewModel.setMeasurementRepository(MeasurementType.carbonDioxide, new Timestamp(from),new Timestamp(to));
            viewModel.getCarbonDioxideFilterMeasurement().observe(getActivity(), measurements -> {
                filterList.clear();
                filterList.addAll(measurements);
                adapter.notifyDataSetChanged();
            });
        } else if (humidity.isChecked()){
            viewModel.setMeasurementRepository(MeasurementType.humidity, new Timestamp(from),new Timestamp(to));
            viewModel.getHumidityFilterMeasurement().observe(getActivity(), measurements -> {
                filterList.clear();
                filterList.addAll(measurements);
                adapter.notifyDataSetChanged();
            });
        }

        else {
            viewModel.setMeasurementRepository(MeasurementType.temperature, new Timestamp(from),new Timestamp(to));
            viewModel.getTemperatureFilterMeasurement().observe(getActivity(), measurements -> {
                filterList.clear();
                filterList.addAll(measurements);
                adapter.notifyDataSetChanged();
            });
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bottomNavigationView.setVisibility(View.VISIBLE);
    }
}