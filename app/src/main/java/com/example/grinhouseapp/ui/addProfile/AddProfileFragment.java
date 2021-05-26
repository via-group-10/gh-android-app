package com.example.grinhouseapp.ui.addProfile;

import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.ui.data.DataViewModel;

import java.util.ArrayList;
import java.util.List;

public class AddProfileFragment extends Fragment {

    private Button cancelButton;
    private Button saveButton;
    private EditText profileName;
    private EditText minTem;
    private EditText maxTem;
    private EditText minHum;
    private EditText maxHum;
    private EditText minCd;
    private EditText maxCd;
    private AddProfileViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel =
                new ViewModelProvider(this).get(AddProfileViewModel.class);
        View view = inflater.inflate(R.layout.fragment_add_profile, container, false);
        cancelButton = view.findViewById(R.id.button_cancel);
        saveButton = view.findViewById(R.id.button_save_profile);
        profileName = view.findViewById(R.id.editTextProfileName);
        minTem = view.findViewById(R.id.editTextTemperatureLow);
        maxTem = view.findViewById(R.id.editTextTemperatureHigh);
        minHum = view.findViewById(R.id.editTextHumidityLow);
        maxHum = view.findViewById(R.id.editTextHumidityHigh);
        minCd = view.findViewById(R.id.editTextCO2Low);
        maxCd = view.findViewById(R.id.editTextCO2High);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getView()).navigate(R.id.navigation_profile);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> lists = new ArrayList<>();
                lists.add(String.valueOf(profileName.getText()));
                lists.add(String.valueOf(minTem.getText()));
                lists.add(String.valueOf(maxTem.getText()));
                lists.add(String.valueOf(minHum.getText()));
                lists.add(String.valueOf(maxHum.getText()));
                lists.add(String.valueOf(minCd.getText()));
                lists.add(String.valueOf(maxCd.getText()));
                ArrayList<String> a = new ArrayList<>();
                for (int i = 0; i < lists.size(); i++) {
                    if (lists.get(i) == null || lists.get(i).equals("")) {
                        Toast.makeText(getActivity(), "Please write all the info", Toast.LENGTH_SHORT).show();
                        a.add(lists.get(i));
                        break;
                    } else if (Integer.parseInt(lists.get(1)) >= Integer.parseInt(lists.get(2)) || Integer.parseInt(lists.get(3)) >=
                            Integer.parseInt(lists.get(4)) || Integer.parseInt(lists.get(5)) >=
                            Integer.parseInt(lists.get(6))) {
                        Toast.makeText(getActivity(), "Invalid values (PLEASE check high/low values)", Toast.LENGTH_SHORT).show();
                        a.add(lists.get(i));
                        break;
                    } else {
                        a.clear();
                    }

                }
                if (a.size() == 0) {
                    //add profile method
                    viewModel.addNewProfile(lists.get(0), Integer.parseInt(lists.get(1)),
                            Integer.parseInt(lists.get(2)), Integer.parseInt(lists.get(3)),
                            Integer.parseInt(lists.get(4)), Integer.parseInt(lists.get(5)),
                            Integer.parseInt(lists.get(6)));
                    Navigation.findNavController(getView()).navigate(R.id.navigation_profile);
                }
            }
        });

        return view;
    }
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        // TODO: Use the ViewModel
//    }
}