package com.example.grinhouseapp.ui.graph;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.model.MeasurementType;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Calendar;
import java.util.Date;

public class GraphFragment extends AppCompatActivity {

    private GraphViewModel viewModel;
    LineGraphSeries<DataPoint> series;
    RadioButton dailyButton, weeklyButton, monthlyButton;
    GraphView graph;
    int category;
    String filter;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_fragment);

        Intent intent = getIntent();
        graph = (GraphView) findViewById(R.id.graph);
        viewModel = new ViewModelProvider(this).get(GraphViewModel.class);

        /** TEMPERATURE = 0 ; HUMIDITY = 1 ; CO2 = 2 **/
        category = intent.getIntExtra("measurement", 0);
        calendar = Calendar.getInstance();
        graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(this));
        graph.getGridLabelRenderer().setNumHorizontalLabels(3);
        filter = "monthly";
        drawGraph(filter);

        dailyButton = findViewById(R.id.dailyButton);
        weeklyButton = findViewById(R.id.weeklyButton);
        monthlyButton = findViewById(R.id.monthlyButton);

        dailyButton.setOnClickListener(v -> {
            filter = "daily";
            drawGraph(filter);
        });

        weeklyButton.setOnClickListener(v -> {
            filter = "weekly";
            drawGraph(filter);
        });

        monthlyButton.setOnClickListener(v -> {
            filter = "monthly";
            drawGraph(filter);
        });

        drawGraph(filter);
    }


    private void drawGraph(String filter)
    {
        switch (category)
        {
            case 0:
                viewModel.setMeasurementRepository(MeasurementType.temperature, filter);
                viewModel.getTemperatureGraphMeasurement().observe(this, measurements -> {
                    graph.removeAllSeries();
                    DataPoint[] dataPoints = new DataPoint[measurements.size()];
                    for (int i = 0;i<measurements.size();i++){
//                        Date[i] = new Date(measurements.get(measurements.size()-1-i).getMeasurementDateTime().getTime()), measurements.get(measurements.size()-1-i).getMeasurementValue());
                        dataPoints[i] = new DataPoint(new Date(measurements.get(measurements.size()-1-i).getMeasurementDateTime().getTime()), measurements.get(measurements.size()-1-i).getMeasurementValue());
                    }
                    Log.i("Graph", "Temperature " + filter);
                    series = new LineGraphSeries<>(dataPoints);
                    graph.getViewport().setMinX(dataPoints[0].getX());
                    graph.getViewport().setMaxX(dataPoints[dataPoints.length - 1].getX());
                    graph.getViewport().setMinY(dataPoints[0].getY());
                    graph.getViewport().setMaxY(dataPoints[dataPoints.length - 1].getY());
                    graph.addSeries(series);
                });
                break;
            case 1:
                viewModel.setMeasurementRepository(MeasurementType.humidity, filter);
                viewModel.getHumidityMeasurement().observe(this, measurements -> {
                    graph.removeAllSeries();
                    DataPoint[] dataPoints = new DataPoint[measurements.size()];
                    for (int i = 0;i<measurements.size();i++){
                        dataPoints[i] = new DataPoint(new Date(measurements.get(measurements.size()-1-i).getMeasurementDateTime().getTime()), measurements.get(measurements.size()-1-i).getMeasurementValue());
                    }
                    Log.i("Graph", "Humidity " + filter);
                    series = new LineGraphSeries<>(dataPoints);
                    graph.getViewport().setMinX(dataPoints[0].getX());
                    graph.getViewport().setMaxX(dataPoints[dataPoints.length - 1].getX());
                    graph.getViewport().setMinY(dataPoints[0].getY());
                    graph.getViewport().setMaxY(dataPoints[dataPoints.length - 1].getY());
                    graph.addSeries(series);
                });
                break;
            case 2:
                viewModel.setMeasurementRepository(MeasurementType.carbonDioxide, filter);
                viewModel.getCarbonDioxideMeasurement().observe(this, measurements -> {
                    graph.removeAllSeries();
                    DataPoint[] dataPoints = new DataPoint[measurements.size()];
                    for (int i = 0;i<measurements.size();i++){
                        dataPoints[i] = new DataPoint(new Date(measurements.get(measurements.size()-1-i).getMeasurementDateTime().getTime()), measurements.get(measurements.size()-1-i).getMeasurementValue());
                    }
                    Log.i("Graph", "CO2 " + filter);
                    series = new LineGraphSeries<>(dataPoints);
                    graph.getViewport().setMinX(dataPoints[0].getX());
                    graph.getViewport().setMaxX(dataPoints[dataPoints.length - 1].getX());
                    graph.getViewport().setMinY(dataPoints[0].getY());
                    graph.getViewport().setMaxY(dataPoints[dataPoints.length - 1].getY());
                    graph.addSeries(series);
                });
                break;
        }
    }


}