package com.example.LocationMocker;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;

public class LocationMock implements Runnable, GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener {
  private Context ctx;
  private Location location;
  LocationClient mLocationClient;

  public LocationMock(Context ctx, Location location) {
    this.ctx = ctx;
    this.location = location;
  }

  @Override
  public void run() {
    mLocationClient = new LocationClient(ctx, this, this);
    mLocationClient.connect();
  }

  public void onConnected(Bundle bundle) {
    System.out.println("Connected");
    mLocationClient.setMockMode(true);
    mLocationClient.setMockLocation(location);
    try {
      Thread.sleep((long) (60 * 1000));
    } catch (InterruptedException e) {
    }
    mLocationClient.disconnect();
  }

  public void onDisconnected() {
    System.out.println("Disconnected");
  }

  public void onConnectionFailed(ConnectionResult connectionResult) {
    System.out.println("Failed");
  }
}
