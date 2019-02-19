package com.example.barang.wanderlust;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;

public class Map extends Fragment implements OnMapReadyCallback {

    public static Map newInstance(){
        Map mappage = new Map();


        return mappage;
    }

    private DrawerLayout drawer;
    private Toolbar toolBar;
    private ActionBarDrawerToggle toggle;

    private GoogleMap mMap;
    private BottomSheetBehavior bottomSheetBehavior;
    Cursor cursor;
    private static boolean firstRun = false;

    private TextView tv_name;
    private TextView tv_address;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.navigation_drawer, null, false);

            SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);


        bottomSheetBehavior = BottomSheetBehavior.from(view.findViewById(R.id.bottomSheetLayout));
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        tv_name = (TextView) view.findViewById(R.id.textView3);
        tv_address = (TextView) view.findViewById(R.id.textView4);

        toolBar = (Toolbar)view.findViewById(R.id.toolbar_main);
        drawer = (DrawerLayout)view.findViewById(R.id.drawer_layout);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolBar);

        toggle = new ActionBarDrawerToggle(getActivity(), drawer, toolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();

        return view;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if(firstRun){

            getLocation();

            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {

                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                    return true;


                }
            });



        }
        else {
            LatLng london = new LatLng(51.51,-0.129);
            mMap.addMarker(new MarkerOptions().position(london).title("You are here!"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(london, 5));
            firstRun=true;
        }
    }



    void getLocation()
    {
        Bundle extras = getActivity().getIntent().getExtras();
        String category = extras.getString("category");
        String city = extras.getString("city");
        String table = extras.getString("table");

        DbHelper myDbHelper = new DbHelper(getActivity());
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        final SQLiteDatabase db = myDbHelper.getReadableDatabase();

        ArrayList<String> list = new ArrayList<String>();
        Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

        if (c.moveToFirst()) {
            while ( !c.isAfterLast() ) {
                list.add( c.getString( c.getColumnIndex("name")) );
                c.moveToNext();
            }
        }

        for(int i=0; i<list.size(); i++)
        {
            if(list.get(i).equals(table))
            {
                cursor = db.rawQuery("SELECT * FROM amsterdam WHERE subCategory = ? AND location = ?", new String[]{category, city});
            }
            else
            {
                cursor = db.rawQuery("SELECT * FROM london WHERE subCategory = ? AND location = ?", new String[]{category, city});
            }
        }

        final LatLngBounds.Builder mapBuilder = new LatLngBounds.Builder();
        boolean addedMarker = false;
        if (cursor != null) {
            while (cursor.moveToNext()) {
                double lat = cursor.getDouble(cursor.getColumnIndex("lat"));
                double lng = cursor.getDouble(cursor.getColumnIndex("lng"));
                int polarity = cursor.getInt(cursor.getColumnIndex("polarity"));

                tv_name.setText(cursor.getString(cursor.getColumnIndex("name")));
                tv_address.setText(cursor.getString(cursor.getColumnIndex("address")));

                LatLng ll = new LatLng(lat, lng);
                MarkerOptions options = new MarkerOptions()
                        .position(ll)
                        .anchor(0.5F, 1.0F)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
                Marker marker = mMap.addMarker(options);
                mapBuilder.include(marker.getPosition());

                addedMarker = true;

                mMap.addCircle(new CircleOptions()
                        .center(new LatLng(lat, lng))
                        .radius(polarity*20)
                        .strokeWidth(0)
                        .fillColor(Color.parseColor("#da70d6")));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ll, 12));

            }

            if (!cursor.isClosed()) {
                cursor.close();
                cursor = null;
            }

        }
    }



}

