package fr.epf.min1.projetandroidvelib;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0003J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0012H\u0016J\b\u0010!\u001a\u00020\u0019H\u0016J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\'H\u0016J\b\u0010(\u001a\u00020\u0014H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lfr/epf/min1/projetandroidvelib/MapsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/gms/maps/GoogleMap$OnInfoWindowClickListener;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "Lcom/google/android/gms/maps/GoogleMap$OnMyLocationButtonClickListener;", "Lcom/google/android/gms/maps/GoogleMap$OnMyLocationClickListener;", "Landroidx/core/app/ActivityCompat$OnRequestPermissionsResultCallback;", "()V", "binding", "Lfr/epf/min1/projetandroidvelib/databinding/ActivityMapsBinding;", "listStations", "", "Lfr/epf/min1/projetandroidvelib/model/StationInformation;", "getListStations", "()Ljava/util/List;", "setListStations", "(Ljava/util/List;)V", "mMap", "Lcom/google/android/gms/maps/GoogleMap;", "enableMyLocation", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onInfoWindowClick", "marker", "Lcom/google/android/gms/maps/model/Marker;", "onMapReady", "googleMap", "onMyLocationButtonClick", "onMyLocationClick", "p0", "Landroid/location/Location;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "synchroApi", "app_debug"})
public final class MapsActivity extends androidx.appcompat.app.AppCompatActivity implements com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener, com.google.android.gms.maps.OnMapReadyCallback, com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener, com.google.android.gms.maps.GoogleMap.OnMyLocationClickListener, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<fr.epf.min1.projetandroidvelib.model.StationInformation> listStations;
    private com.google.android.gms.maps.GoogleMap mMap;
    private fr.epf.min1.projetandroidvelib.databinding.ActivityMapsBinding binding;
    
    public MapsActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<fr.epf.min1.projetandroidvelib.model.StationInformation> getListStations() {
        return null;
    }
    
    public final void setListStations(@org.jetbrains.annotations.NotNull()
    java.util.List<fr.epf.min1.projetandroidvelib.model.StationInformation> p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onMapReady(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap googleMap) {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void enableMyLocation() {
    }
    
    @java.lang.Override()
    public void onInfoWindowClick(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.Marker marker) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void synchroApi() {
    }
    
    @java.lang.Override()
    public boolean onMyLocationButtonClick() {
        return false;
    }
    
    @java.lang.Override()
    public void onMyLocationClick(@org.jetbrains.annotations.NotNull()
    android.location.Location p0) {
    }
}