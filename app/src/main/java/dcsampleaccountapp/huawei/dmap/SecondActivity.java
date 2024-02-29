package dcsampleaccountapp.huawei.dmap;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.huawei.hms.maps.CameraUpdateFactory;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.OnMapReadyCallback;
import com.huawei.hms.maps.SupportMapFragment;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.Marker;

public class SecondActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final String TAG = "SupportMapDemoActivity";

    private static final LatLng Beijing = new LatLng(48.893478, 2.334595);

    private static final LatLng Shanghai = new LatLng(48.7, 2.12);

    private HuaweiMap hMap;

    private Marker mBeijing;

    private Marker mShanghai;

    private SupportMapFragment mSupportMapFragment;

    private boolean visible = true;

    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // Request permission
        startLocationPermissionRequest();
        mSupportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.supportMap);
        mSupportMapFragment.getMapAsync(this);
    }

    private boolean checkPermissions() {
        int permissionState = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION);
        return permissionState == PackageManager.PERMISSION_GRANTED;
    }

    private void startLocationPermissionRequest() {
        ActivityCompat.requestPermissions(SecondActivity.this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                REQUEST_PERMISSIONS_REQUEST_CODE);
    }

    @Override
    public void onMapReady(HuaweiMap map) {
        Log.d(TAG, "onMapReady: ");
        hMap = map;
        hMap.getUiSettings().setCompassEnabled(true);
        hMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(48.893478, 2.334595), 14));
        hMap.setOnMapLongClickListener(new HuaweiMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                Log.d(TAG, "onMapLongClick: latLng " + " please input latLng");
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mSupportMapFragment.onSaveInstanceState(outState);
    }

    public void setVisiable(View view) {
        if (null != mBeijing) {
            if (visible) {
                mBeijing.setVisible(true);
                visible = false;
            } else {
                mBeijing.setVisible(false);
                visible = true;
            }
        }
    }

    public void setAlpha(View view) {
        if (null != mBeijing) {
            if (visible) {
                mBeijing.setAlpha(0.5f);
                visible = false;
            } else {
                mBeijing.setAlpha(1.0f);
                visible = true;
            }
        }
    }

    public void setFlat(View view) {
        if (null != mBeijing) {
            if (visible) {
                mBeijing.setFlat(true);
                visible = false;
            } else {
                mBeijing.setFlat(false);
                visible = true;
            }
        }
    }

    public void setZIndex(View view) {
        if (null != mBeijing) {
            if (visible) {
                mBeijing.setZIndex(20f);
                visible = false;
            } else {
                mBeijing.setZIndex(-20f);
                visible = true;
            }
        }
    }

    public void setRotation(View view) {
        if (null != mBeijing) {
            if (visible) {
                mBeijing.setRotation(30.0f);
                visible = false;
            } else {
                mBeijing.setRotation(60.0f);
                visible = true;
            }
        }
    }

    public void removeMarker(View view) {
        if (null != mBeijing) {
            mBeijing.remove();
            mBeijing = null;
        }

        if (null != mShanghai) {
            mShanghai.remove();
            mShanghai = null;
        }
    }

    public void showInfoWindow(View view) {
        if (null != mBeijing) {
            if (visible) {
                mBeijing.showInfoWindow();
                visible = false;
            } else {
                mBeijing.hideInfoWindow();
                visible = true;
            }
        }
    }

    public void setAnchor(View view) {
        if (null != mBeijing) {
            mBeijing.setMarkerAnchor(0.9F, 0.9F);
        }
    }
}