package com.example.grinhouseapp.ui.editProfile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.model.ThresholdProfile;
import com.example.grinhouseapp.ui.addProfile.AddProfileViewModel;
import com.example.grinhouseapp.ui.profile.ProfileAdapter;

import java.util.ArrayList;
import java.util.List;

public class EditProfileFragment  extends Fragment {
    private EditProfileViewModel viewModel;
    private Button cancelButton;
    private Button saveButton;
    private EditText profileName;
    private EditText minTem;
    private EditText maxTem;
    private EditText minHum;
    private EditText maxHum;
    private EditText minCd;
    private EditText maxCd;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel =
                new ViewModelProvider(this).get(EditProfileViewModel.class);
        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        cancelButton = view.findViewById(R.id.button_Update_cancel);
        saveButton = view.findViewById(R.id.button_save_Update_profile);
        profileName = (EditText) view.findViewById(R.id.updateTextProfileName);
        minTem =(EditText)  view.findViewById(R.id.updateTextTemperatureLow);
        maxTem =(EditText)  view.findViewById(R.id.updateTextTemperatureHigh);
        minHum =(EditText)  view.findViewById(R.id.updateTextHumidityLow);
        maxHum =(EditText)  view.findViewById(R.id.updateTextHumidityHigh);
        minCd =(EditText)  view.findViewById(R.id.updateTextCO2Low);
        maxCd =(EditText)  view.findViewById(R.id.updateTextCO2High);


        if (EditProfileViewModel.OldProfile!=null)
        {
            profileName.setText(EditProfileViewModel.OldProfile.getProfileName());
            minTem.setText(String.valueOf(EditProfileViewModel.OldProfile.getMinimumTemperature()));
            maxTem.setText(String.valueOf(EditProfileViewModel.OldProfile.getMaximumTemperature()));
            minHum.setText(String.valueOf(EditProfileViewModel.OldProfile.getMinimumHumidity()));
            maxHum.setText(String.valueOf(EditProfileViewModel.OldProfile.getMaximumHumidity()));
            minCd.setText(String.valueOf(EditProfileViewModel.OldProfile.getMinimumCarbonDioxide()));
            maxCd.setText(String.valueOf(EditProfileViewModel.OldProfile.getMaximumCarbonDioxide()));
        }


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
                for (int i = 0; i<lists.size();i++) {
                    if (lists.get(i) == null || lists.get(i).equals("")) {
                        Toast.makeText(getActivity(), "Please write all the info", Toast.LENGTH_SHORT).show();
                        a.add(lists.get(i));
                        break;
                    }
                    else if (Integer.parseInt(lists.get(1))>= Integer.parseInt(lists.get(2)) || Integer.parseInt(lists.get(3))>=
                            Integer.parseInt(lists.get(4)) || Integer.parseInt(lists.get(5))>=
                            Integer.parseInt(lists.get(6)))
                    {
                        Toast.makeText(getActivity(),"Invalid values (PLEASE check high/low values)",Toast.LENGTH_SHORT).show();
                        a.add(lists.get(i));
                        break;
                    }
                    else
                    {
                        a.clear();
                    }
                }
                if (a.size()==0)
                {
                    //add profile method
                    viewModel.updateProfile(lists.get(0),Integer.parseInt(lists.get(1)),
                            Integer.parseInt(lists.get(2)),Integer.parseInt(lists.get(3)),
                            Integer.parseInt(lists.get(4)),Integer.parseInt(lists.get(5)),
                            Integer.parseInt(lists.get(6)));
                    Navigation.findNavController(getView()).navigate(R.id.navigation_profile);
                    ProfileAdapter.ifActivate=true;
                }
            }
        });

        return view;
    }
}