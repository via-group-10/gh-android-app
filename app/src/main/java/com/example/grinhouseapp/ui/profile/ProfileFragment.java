package com.example.grinhouseapp.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.model.ThresholdProfile;
import com.example.grinhouseapp.ui.home.HomeViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProfileFragment extends Fragment implements ProfileAdapter.OnListItemClickListener{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fab;
    private ProfileViewModel viewModel;
    private ArrayList<ThresholdProfile> profileList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //@TODO: decrease RecycleViews loading time

        viewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);
        viewModel.setProfileRepository();

        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.navigateToProfilesFragment);
            }
        });
        profileList = new ArrayList<>();

        recyclerView = root.findViewById(R.id.profileRecView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        adapter = new ProfileAdapter(profileList, this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        viewModel.getAllProfiles().observe(getViewLifecycleOwner(), thresholdProfiles -> {
            profileList.clear();
            List<ThresholdProfile> profiles = viewModel.getAllProfilesInList();
            Collections.reverse(profiles);
            profileList.addAll(profiles);
            adapter.notifyDataSetChanged();
        });


        return root;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        //@TODO: clickable buttons
        viewModel.deleteProfile(profileList.get(clickedItemIndex).getProfileId());
        profileList.remove(clickedItemIndex);
        adapter.notifyItemRemoved(clickedItemIndex);
        adapter.notifyItemRangeChanged(clickedItemIndex,adapter.getItemCount());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void deleteProfile(int id,int position){
        viewModel.deleteProfile(id);
        profileList.remove(position);
        adapter.notifyItemRemoved(position);
        adapter.notifyItemRangeChanged(position,adapter.getItemCount());
        adapter.notifyDataSetChanged();
    }



}