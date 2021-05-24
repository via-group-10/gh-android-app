package com.example.grinhouseapp.ui.graph;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.model.Measurement;
import com.example.grinhouseapp.model.MeasurementType;
import com.example.grinhouseapp.ui.data.DataViewModel;
import com.example.grinhouseapp.ui.filter.FilterViewModel;
import com.github.mikephil.charting.data.Entry;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GraphFragment extends AppCompatActivity {

    private GraphViewModel viewModel;
    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_fragment);

        Intent intent = getIntent();
        GraphView graph = (GraphView) findViewById(R.id.graph);
        viewModel = new ViewModelProvider(this).get(GraphViewModel.class);

        /** TEMPERATURE = 0 ; HUMIDITY = 1 ; CO2 = 2 **/
        int category = intent.getIntExtra("measurement", 0);
        /*switch (category)
        {
            case 0:
               break;
        }*/

        viewModel.setMeasurementRepository(MeasurementType.temperature, "monthly");
        viewModel.getTemperatureGraphMeasurement().observe(this, measurements -> {
            Log.i("Size", measurements.size()+"");
            DataPoint[] dataPoints = new DataPoint[measurements.size()];
            for (int i = 0;i<measurements.size();i++){
                dataPoints[i] = new DataPoint(new Date(measurements.get(measurements.size()-1-i).getMeasurementDateTime().getTime()), measurements.get(measurements.size()-1-i).getMeasurementValue());
                Log.i("Measurement" + i, dataPoints[i].getX() + " - " +dataPoints[i].getY());
            }
            series = new LineGraphSeries<>(dataPoints);
            graph.addSeries(series);
        });




    }


    private String toDate(long timestamp) {
        Date date = new Date(timestamp);
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }


}