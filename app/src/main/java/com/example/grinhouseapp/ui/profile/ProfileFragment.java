package com.example.grinhouseapp.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grinhouseapp.NetworkCheck;
import com.example.grinhouseapp.R;
import com.example.grinhouseapp.model.ThresholdProfile;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;

public class ProfileFragment extends Fragment implements ProfileAdapter.OnListItemClickListener{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fab;
    private ProfileViewModel viewModel;
    private ArrayList<ThresholdProfile> profileList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);
        viewModel.setProfileRepository();

        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        fab = root.findViewById(R.id.fab);
        if(!NetworkCheck.isInternetAvailable(getContext())) {
            Toast.makeText(getContext(), "You are not connected. Profiles cannot be viewed", Toast.LENGTH_SHORT).show();
            fab.setVisibility(View.GONE);
        }
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
            Collections.reverse(thresholdProfiles);
            profileList.addAll(thresholdProfiles);
            adapter.notifyDataSetChanged();
        });


        return root;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        ProfileDialog.showAlertDialog(getActivity(), true, new ProfileDialog.AlertDialogBtnClickListener() {
            @Override
            public void clickApply() {
                if (!profileList.get(clickedItemIndex).isActive()) {
                    for (ThresholdProfile thresholdProfile : profileList) {
                        thresholdProfile.setActive(false);
                    }
                }
                profileList.get(clickedItemIndex).setActive(!profileList.get(clickedItemIndex).isActive());
                viewModel.updateProfile(profileList.get(clickedItemIndex));
                adapter.notifyDataSetChanged();
            }
            @Override
            public void clickCancel() {

            }
        });
    }

    @Override
    public void deleteProfile(int id,int position){
        viewModel.deleteProfile(id);
        profileList.remove(position);
        adapter.notifyItemRemoved(position);
        adapter.notifyItemRangeChanged(position,adapter.getItemCount());
        adapter.notifyDataSetChanged();
        ProfileAdapter.ifActivate=true;
    }
    @Override
    public void updateProfile(int position)
    {
        Navigation.findNavController(getView()).navigate(R.id.navigateToUpdateProfilesFragment);
        adapter.notifyDataSetChanged();
    }
}