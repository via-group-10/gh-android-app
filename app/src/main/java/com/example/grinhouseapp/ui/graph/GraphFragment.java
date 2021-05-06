package com.example.grinhouseapp.ui.graph;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.model.Measurement;
import com.example.grinhouseapp.ui.data.DataViewModel;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class GraphFragment extends AppCompatActivity {

    private GraphViewModel viewModel;
    private LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_fragment);

        Intent intent = getIntent();

        /** TEMPERATURE = 0 ; HUMIDITY = 1 ; CO2 = 2 **/
        int category = intent.getIntExtra("measurement", 0);

        mChart = (LineChart) findViewById(R.id.chart);
//        mChart.setOnChartGestureListener(GraphFragment.this);
//        mChart.setOnChartValueSelectedListener(GraphFragment.this);
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(false);

        ArrayList<Entry> yValues = new ArrayList<>();


        viewModel.setTemperatureMeasurements("daily",category);

        viewModel.getMeasurements(category).observe(this, measurements ->
        {
            for(Measurement measurement : measurements)
            {
                yValues.add(measurement.getMeasurementValue(), measurement.getMeasurementDateTime());
            }
        });

        LineDataSet set1 = new LineDataSet(yValues,"Data set 1");

        set1.setFillAlpha(110);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);
        mChart.setData(data);
    }
}