package com.example.grinhouseapp.ui.data;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.grinhouseapp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

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

        return root;
    }
}