package com.example.grinhouseapp.ui.graph;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.ui.data.DataViewModel;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class GraphFragment extends Fragment  {

    private GraphViewModel mViewModel;
    private LineChart mChart;
    private DataViewModel dataViewModel;
    public static GraphFragment newInstance() {
        return new GraphFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.graph_fragment, container, false);
        mChart = (LineChart) view.findViewById(R.id.chart);
//        mChart.setOnChartGestureListener(GraphFragment.this);
//        mChart.setOnChartValueSelectedListener(GraphFragment.this);
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(false);

        ArrayList<Entry> yValues = new ArrayList<>();

        yValues.add(new Entry(mViewModel.getCarbonDioxideMeasurement(),60f));
        yValues.add(new Entry(2,10f));
        yValues.add(new Entry(3,80f));
        yValues.add(new Entry(6,90f));

        LineDataSet set1 = new LineDataSet(yValues,"Data set 1");

        set1.setFillAlpha(110);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);
        mChart.setData(data);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(GraphViewModel.class);
        // TODO: Use the ViewModel
    }



}