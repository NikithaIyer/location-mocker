package com.example.LocationMocker;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.EditText;

public class MyActivity extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  public void setLocation(View v) {
    final String latValue = ((EditText) findViewById(R.id.latitudeValue)).getText().toString();
    final String longValue = ((EditText) findViewById(R.id.longitudeValue)).getText().toString();

    new Thread(new LocationMock(this, createLocation(Double.parseDouble(latValue), Double.parseDouble(longValue), 5))).start();
  }

  public Location createLocation(double lat, double lng, float accuracy) {
    Location newLocation = new Location("flp");
    newLocation.setLatitude(lat);
    newLocation.setLongitude(lng);
    newLocation.setAccuracy(accuracy);
    newLocation.setTime(System.currentTimeMillis());
    newLocation.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());
    return newLocation;
  }

}
