package com.example.barang.fyp;


import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SelectDays extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectdays);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng london = new LatLng(51.51,-0.129);
        mMap.addMarker(new MarkerOptions().position(london).title("You are here!"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(london, 13));

        //BARS
        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.516632,-0.12922999999999998))
                .radius(120)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#bc8f8f")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.513959696278,-0.15796412902560994))
                .radius(140)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#bc8f8f")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.518610847531, -0.17131805419922005))
                .radius(140)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#bc8f8f")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.527421, -0.081525))
                .radius(120)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#bc8f8f")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.513867974281, -0.095422267913818))
                .radius(140)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#bc8f8f")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.51623396, -0.140317))
                .radius(160)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#bc8f8f")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.516025, -0.150654))
                .radius(200)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#bc8f8f")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.516407722840995, -0.17659076035993))
                .radius(80)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#bc8f8f")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.513737, -0.100965))
                .radius(160)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#bc8f8f")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.52027130127, -0.10161130130291))
                .radius(160)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#bc8f8f")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.523257196834, -0.10106563568115))
                .radius(140)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#bc8f8f")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.524739187762, -0.14255989792617))
                .radius(120)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#bc8f8f")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.525776, -0.133167))
                .radius(160)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#bc8f8f")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.515404, -0.191306))
                .radius(160)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#bc8f8f")));

        //COCKTAIL BARS
        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.51517934311301, -0.15170852128918))
                .radius(160)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#da70d6")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.514229, -0.141148))
                .radius(140)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#da70d6")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.532111025474, -0.12067823643388))
                .radius(120)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#da70d6")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.524857, -0.08214400000000001))
                .radius(120)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#da70d6")));


        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.51184040725099, -0.13709442962287))
                .radius(140)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#da70d6")));


        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.51123659562701, -0.13973881421826))
                .radius(140)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#da70d6")));


        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.51650114166, -0.12602090835571))
                .radius(160)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#da70d6")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.512661678894, -0.14543340828251))
                .radius(160)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#da70d6")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.518358630832005, -0.15435713327462))
                .radius(160)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#da70d6")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.511778429322995, -0.11871984816296))
                .radius(120)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#da70d6")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.53189, -0.120724))
                .radius(180)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#da70d6")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.520848128336, -0.14234894565663))
                .radius(180)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#da70d6")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.526420501039, -0.08782969041600401))
                .radius(160)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#da70d6")));


        //WINE BARS
        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.531013407554, -0.12166500091553))
                .radius(200)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#87ceeb")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.525393918238, -0.17828617238494002))
                .radius(120)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#87ceeb")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.530853223794004, -0.12548446655273))
                .radius(170)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#87ceeb")));

        //SPORTS BARS
        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.518050049177, -0.1084041595459))
                .radius(140)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#6a5acd")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.52598690076999, -0.10898675781392))
                .radius(160)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#6a5acd")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.515718322457, -0.13673901557922))
                .radius(140)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#6a5acd")));

        //GAY BARS
        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.53341510997, -0.12081702769196))
                .radius(140)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#fffacd")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.512671440952, -0.13264142749155))
                .radius(140)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#fffacd")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.512255691501, -0.13292654189158))
                .radius(180)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#fffacd")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.513376932822, -0.13091053587938))
                .radius(100)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#fffacd")));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.51213454124699, -0.13376712799072))
                .radius(160)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#fffacd")));

        //HOOKAH BAR
        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.516718779844, -0.1438224175756))
                .radius(100)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#66cdaa")));

        //HOTEL BAR
        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.519433, -0.169213))
                .radius(80)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#f4a460")));

        //WHISKY BAR
        mMap.addCircle(new CircleOptions()
                .center(new LatLng(51.514308863471, -0.16165559413911))
                .radius(120)
                .strokeWidth(0)
                .fillColor(Color.parseColor("#b03060")));



    }
}
