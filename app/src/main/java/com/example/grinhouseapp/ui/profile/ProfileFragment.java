package com.example.grinhouseapp.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.model.ThresholdProfile;
import com.example.grinhouseapp.ui.home.HomeViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fab;
    private ProfileViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        viewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);
        viewModel.setProfileRepository();

        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        ArrayList<ThresholdProfile> profileList = new ArrayList<>();
        fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "soon", Toast.LENGTH_SHORT).show();
            }
        });

        viewModel.getAllProfiles().observe(getViewLifecycleOwner(), thresholdProfiles -> {
            profileList.addAll(thresholdProfiles);
        });

        recyclerView = root.findViewById(R.id.profileRecView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        adapter = new ProfileAdapter(profileList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return root;
    }


}