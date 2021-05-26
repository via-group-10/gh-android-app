package com.example.grinhouseapp.ui.data;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.grinhouseapp.R;

import com.example.grinhouseapp.model.Measurement;
import com.example.grinhouseapp.model.MeasurementType;
import com.example.grinhouseapp.ui.graph.GraphFragment;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class DataFragment extends Fragment {

    private DataViewModel dataViewModel;
    private TextView temDate1;
    private TextView temDate2;
    private TextView temDate3;
    private TextView temTime1;
    private TextView temTime2;
    private TextView temTime3;
    private TextView temValue1;
    private TextView temValue2;
    private TextView temValue3;
    private TextView humDate1;
    private TextView humDate2;
    private TextView humDate3;
    private TextView humTime1;
    private TextView humTime2;
    private TextView humTime3;
    private TextView humValue1;
    private TextView humValue2;
    private TextView humValue3;
    private TextView cdDate1;
    private TextView cdDate2;
    private TextView cdDate3;
    private TextView cdTime1;
    private TextView cdTime2;
    private TextView cdTime3;
    private TextView cdValue1;
    private TextView cdValue2;
    private TextView cdValue3;
    private TextView moreTemperatureBtn;
    private TextView moreHumidityBtn;
    private TextView moreCO2Btn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dataViewModel =
                new ViewModelProvider(this).get(DataViewModel.class);

        View root = inflater.inflate(R.layout.fragment_data, container, false);

        temDate1 = root.findViewById(R.id.temperatureDate1);
        temDate2 = root.findViewById(R.id.temperatureDate2);
        temDate3 = root.findViewById(R.id.temperatureDate3);
        temTime1 = root.findViewById(R.id.temperatureTime1);
        temTime2 = root.findViewById(R.id.temperatureTime2);
        temTime3 = root.findViewById(R.id.temperatureTime3);
        temValue1 = root.findViewById(R.id.temperatureValue1);
        temValue2 = root.findViewById(R.id.temperatureValue2);
        temValue3 = root.findViewById(R.id.temperatureValue3);
        humDate1 = root.findViewById(R.id.humidityDate1);
        humDate2 = root.findViewById(R.id.humidityDate2);
        humDate3 = root.findViewById(R.id.humidityDate3);
        humTime1 = root.findViewById(R.id.HumidityTime1);
        humTime2 = root.findViewById(R.id.humidityTime2);
        humTime3 = root.findViewById(R.id.humidityTime3);
        humValue1 = root.findViewById(R.id.HumidityValue1);
        humValue2 = root.findViewById(R.id.humidityValue2);
        humValue3 = root.findViewById(R.id.humidityValue3);
        cdDate1 = root.findViewById(R.id.CO2Date1);
        cdDate2 = root.findViewById(R.id.CO2Date2);
        cdDate3 = root.findViewById(R.id.CO2Date3);
        cdTime1 = root.findViewById(R.id.CO2Time1);
        cdTime2 = root.findViewById(R.id.CO2Time2);
        cdTime3 = root.findViewById(R.id.CO2Time3);
        cdValue1 = root.findViewById(R.id.CO2Value1);
        cdValue2 = root.findViewById(R.id.CO2Value2);
        cdValue3 = root.findViewById(R.id.CO2Value3);

        moreTemperatureBtn = root.findViewById(R.id.seeMoreTemperature);
        moreCO2Btn = root.findViewById(R.id.seeMoreCO2);
        moreHumidityBtn = root.findViewById(R.id.seeMoreHumidity);

        moreTemperatureBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity().getBaseContext(), GraphFragment.class);
            intent.putExtra("measurement", 0);
            getActivity().startActivity(intent);
        });

        moreHumidityBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity().getBaseContext(), GraphFragment.class);
            intent.putExtra("measurement", 1);
            getActivity().startActivity(intent);
        });

        moreCO2Btn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity().getBaseContext(), GraphFragment.class);
            intent.putExtra("measurement", 2);
            getActivity().startActivity(intent);
        });

        getTableForMeasurement(MeasurementType.temperature);
        getTableForMeasurement(MeasurementType.humidity);
        getTableForMeasurement(MeasurementType.carbonDioxide);



        return root;
    }



    private void getTableForMeasurement(MeasurementType measurementType)
    {
        dataViewModel.getMeasurementsDB(measurementType).observe(getViewLifecycleOwner(), measurements -> {
            try {
                writeToTable(measurementType, measurements);
            } catch (IndexOutOfBoundsException e)
            {
                e.getMessage();
            }
        });
    }

    private void writeToTable(MeasurementType measurementType, List<Measurement> measurements) throws IndexOutOfBoundsException
    {
        if(measurementType == MeasurementType.temperature) {
            temDate1.setText(toDate(new Timestamp(measurements.get(0).getMeasurementDateTimeLong())));
            temTime1.setText(toTime((new Timestamp(measurements.get(0).getMeasurementDateTimeLong()))));
            temValue1.setText(measurements.get(0).getMeasuredValue() + "℃");

            temDate2.setText((toDate(new Timestamp(measurements.get(1).getMeasurementDateTimeLong()))));
            temTime2.setText((toTime(new Timestamp(measurements.get(1).getMeasurementDateTimeLong()))));
            temValue2.setText(measurements.get(1).getMeasuredValue() + "℃");

            temDate3.setText(toDate((new Timestamp(measurements.get(2).getMeasurementDateTimeLong()))));
            temTime3.setText(toTime((new Timestamp(measurements.get(2).getMeasurementDateTimeLong()))));
            temValue3.setText(measurements.get(2).getMeasuredValue() + "℃");

        }
        else if(measurementType == MeasurementType.humidity) {
            humDate1.setText(toDate((new Timestamp(measurements.get(0).getMeasurementDateTimeLong()))));
            humTime1.setText(toTime((new Timestamp(measurements.get(0).getMeasurementDateTimeLong()))));
            humValue1.setText(measurements.get(0).getMeasuredValue() + "%");

            humDate2.setText(toDate(new Timestamp(measurements.get(1).getMeasurementDateTimeLong())));
            humTime2.setText(toTime(new Timestamp(measurements.get(1).getMeasurementDateTimeLong())));
            humValue2.setText(measurements.get(1).getMeasuredValue() + "%");

            humDate3.setText(toDate((new Timestamp(measurements.get(2).getMeasurementDateTimeLong()))));
            humTime3.setText(toTime((new Timestamp(measurements.get(2).getMeasurementDateTimeLong()))));
            humValue3.setText(measurements.get(2).getMeasuredValue() + "%");
        }
        else {
            cdDate1.setText(toDate((new Timestamp(measurements.get(0).getMeasurementDateTimeLong()))));
            cdTime1.setText(toTime((new Timestamp(measurements.get(0).getMeasurementDateTimeLong()))));
            cdValue1.setText(measurements.get(0).getMeasuredValue() + "ppm");

            cdDate2.setText(toDate(new Timestamp(measurements.get(1).getMeasurementDateTimeLong())));
            cdTime2.setText(toTime(new Timestamp(measurements.get(1).getMeasurementDateTimeLong())));
            cdValue2.setText(measurements.get(1).getMeasuredValue() + "ppm");

            cdDate3.setText(toDate((new Timestamp(measurements.get(2).getMeasurementDateTimeLong()))));
            cdTime3.setText(toTime((new Timestamp(measurements.get(2).getMeasurementDateTimeLong()))));
            cdValue3.setText(measurements.get(2).getMeasuredValue() + "ppm");
        }
    }

    private String toDate(Timestamp timestamp)
    {
        return new SimpleDateFormat("dd.MM.yyyy").format(timestamp);
    }

    private String toTime(Timestamp timestamp)
    {
        return new SimpleDateFormat("HH:mm").format(timestamp);
    }
}