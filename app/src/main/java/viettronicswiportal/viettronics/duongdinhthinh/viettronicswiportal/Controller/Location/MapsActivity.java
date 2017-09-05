package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.Location;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ProgressDialog dialog;
    private int REQUEST_ID_ACCESS_COURSE_FINE_LOCATION = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        createProgressDialog();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment);
        mapFragment.getMapAsync(this);
        
    }

    private void createProgressDialog() {
        dialog = new ProgressDialog(MapsActivity.this);
        dialog.setTitle("Map Loading...");
        dialog.setMessage("Please wait...");
        dialog.setCancelable(true);
        dialog.show();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                /*Tải map thành công*/
                dialog.dismiss();
                /*Hiển thị vị trí người dùng*/
                askPermissionAndLocation();
            }
        });
    }

    private void askPermissionAndLocation() {
        // Với API >= 23, bạn phải hỏi người dùng cho phép xem vị trí của họ.
        if (Build.VERSION.SDK_INT >= 23) {
            int accessCoarsePermission
                    = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
            int accessFinePermission
                    = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

            if (accessCoarsePermission != PackageManager.PERMISSION_GRANTED
                    || accessFinePermission != PackageManager.PERMISSION_GRANTED) {

                // Các quyền cần người dùng cho phép.
                String[] permissions = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION};

                // Hiển thị một Dialog hỏi người dùng cho phép các quyền trên.
                ActivityCompat.requestPermissions(this, permissions,
                        REQUEST_ID_ACCESS_COURSE_FINE_LOCATION);

                return;
            }
        }
        this.showLocation();
    }

    private void showLocation() {
        LatLng viettronics = new LatLng(21.0059882,105.8231402);
        MarkerOptions options = new MarkerOptions();
        options.position(viettronics);
        options.title("Tổng Công ty CP Điện tử và Tin học Việt Nam").snippet("Viettronics");
        options.rotation(90);
        options.alpha(0.8f);
        Marker marker = mMap.addMarker(options);
        marker.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(viettronics, 15));
    }
}
