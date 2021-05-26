package com.example.grinhouseapp.ui.deviceState;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.grinhouseapp.R;


public class DeviceStateActivity extends AppCompatActivity {
    private DeviceStateViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel =
                new ViewModelProvider(this).get(DeviceStateViewModel.class);
        viewModel.setACState();
        viewModel.setCo2GeneratorState();
        viewModel.setHumidifierState();
        setContentView(R.layout.activity_device_state);
        Toolbar toolbar = findViewById(R.id.up_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SwitchCompat heaterSwitchCompat = findViewById(R.id.heaterState);
        SwitchCompat coolerSwitchCompat = findViewById(R.id.coolerState);
        SwitchCompat CO2SwitchCompat = findViewById(R.id.co2State);
        SwitchCompat HumidifierSwitchCompat = findViewById(R.id.humidifierState);
        SwitchCompat deHumidifierSwitchCompat = findViewById(R.id.deHumidifierState);




        viewModel.getCurrentAcState().observe(this, currentAcState ->{
            coolerSwitchCompat.setChecked(currentAcState.isCoolerOn());
            heaterSwitchCompat.setChecked(currentAcState.isHeaterOn());
        });

        viewModel.getCurrentCo2GeneratorState().observe(this, currentCo2GeneratorState ->{
            CO2SwitchCompat.setChecked(currentCo2GeneratorState.isCarbonDioxideGeneratorOn());
        });

        viewModel.getCurrentHumidifierState().observe(this, humidifierState -> {
            HumidifierSwitchCompat.setChecked(humidifierState.humidifierOn());
            deHumidifierSwitchCompat.setChecked(humidifierState.dehumidifierOn());
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.menu.up_nav){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}