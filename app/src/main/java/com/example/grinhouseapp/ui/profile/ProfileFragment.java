package com.example.grinhouseapp.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.ui.addProfile.AddProfileFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fab;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        ArrayList<ProfileItem> profileList = new ArrayList<>();

        fab = root.findViewById(R.id.fab);
        container.clearDisappearingChildren();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.navigateToProfilesFragment);
            }
        });
        profileList.add(new ProfileItem("Sweet strawberry",23,45,65));
        profileList.add(new ProfileItem("Blueberry",23,45,65));
        profileList.add(new ProfileItem("Mrkva",23,45,65));
        profileList.add(new ProfileItem("Paprika",21,64,90));
        profileList.add(new ProfileItem("Paprika",21,64,90));

        profileList.add(new ProfileItem("Paprika",21,64,90));

        recyclerView = root.findViewById(R.id.profileRecView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        adapter = new ProfileAdapter(profileList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return root;
    }





}