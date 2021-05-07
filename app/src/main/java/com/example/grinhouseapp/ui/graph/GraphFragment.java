package com.example.grinhouseapp.ui.graph;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;

import com.example.grinhouseapp.R;
import com.github.mikephil.charting.data.Entry;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class GraphFragment extends AppCompatActivity {

    private GraphViewModel viewModel;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_fragment);

        Intent intent = getIntent();
        GraphView graph = (GraphView) findViewById(R.id.graph);


        /** TEMPERATURE = 0 ; HUMIDITY = 1 ; CO2 = 2 **/
        int category = intent.getIntExtra("measurement", 0);



        ArrayList<Entry> yValues = new ArrayList<>();
        LineGraphSeries<DataPoint> series = null;
            series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                    new DataPoint(1, 0),
                    new DataPoint(2, 5),
                    new DataPoint(3, 3),
                    new DataPoint(4, 2),
                    new DataPoint(5, 6)
            });
        
        graph.addSeries(series);

        //viewModel.setTemperatureMeasurements("daily",category);
//        viewModel.getMeasurements(category).observe(this, measurements ->
//        {
//            for(Measurement measurement : measurements)
//            {
//                LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
//                        new DataPoint(measurement.getMeasurementValue(),  measurement.getMeasurementValue()),
//                        new DataPoint(measurement.getMeasurementDateTime(), measurement.getMeasurementValue()),
//                        new DataPoint(measurement.getMeasurementDateTime(), measurement.getMeasurementValue()),
//                        new DataPoint(measurement.getMeasurementDateTime(), measurement.getMeasurementValue()),
//
//                });
//                graph.addSeries(series);
//
////                yValues.add(new Entry(measurement.getMeasurementValue(), measurement.getMeasurementDateTime());
//            }
//        });




//
//        LineDataSet set1 = new LineDataSet(yValues,"Data set 1");
//
//        set1.setFillAlpha(110);
//
//        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
//        dataSets.add(set1);
//
//        LineData data = new LineData(dataSets);
//        mChart.setData(data);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private String toDate(long timestamp) {
        Date date = new Date(timestamp * 1000);
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }


}