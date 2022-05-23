package fr.epf.min1.projetandroidvelib;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006#"}, d2 = {"Lfr/epf/min1/projetandroidvelib/DetailsStationsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "detailStation", "Lfr/epf/min1/projetandroidvelib/model/StationStatus;", "getDetailStation", "()Lfr/epf/min1/projetandroidvelib/model/StationStatus;", "setDetailStation", "(Lfr/epf/min1/projetandroidvelib/model/StationStatus;)V", "op", "", "getOp", "()Ljava/lang/String;", "setOp", "(Ljava/lang/String;)V", "stationId", "", "getStationId", "()I", "setStationId", "(I)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "printDetails", "printDetailsHC", "synchroApi", "app_debug"})
public final class DetailsStationsActivity extends androidx.appcompat.app.AppCompatActivity {
    public fr.epf.min1.projetandroidvelib.model.StationStatus detailStation;
    private int stationId = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String op = "Non";
    
    public DetailsStationsActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final fr.epf.min1.projetandroidvelib.model.StationStatus getDetailStation() {
        return null;
    }
    
    public final void setDetailStation(@org.jetbrains.annotations.NotNull()
    fr.epf.min1.projetandroidvelib.model.StationStatus p0) {
    }
    
    public final int getStationId() {
        return 0;
    }
    
    public final void setStationId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOp() {
        return null;
    }
    
    public final void setOp(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
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
    
    private final void printDetails() {
    }
    
    private final void printDetailsHC() {
    }
}