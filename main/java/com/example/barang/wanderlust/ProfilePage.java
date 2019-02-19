package com.example.barang.wanderlust;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ProfilePage extends Fragment {
    public static ProfilePage newInstance(){
        ProfilePage profilepage = new ProfilePage();
        return profilepage;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
    }
}
