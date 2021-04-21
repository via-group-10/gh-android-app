package com.example.grinhouseapp.ui.home;

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
import com.example.grinhouseapp.treshold.TemperatureActivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
       //final TextView textView = root.findViewById(R.id);
       //homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
       //    @Override
       //    public void onChanged(@Nullable String s) {
       //        textView.setText(s);
       //    }
       //});
        TextView textView= (TextView) root.findViewById(R.id.text_temData);
        textView.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), TemperatureActivity.class);
            startActivity(intent);
        });

        return root;

    }


}