package fr.epf.min1.projetandroidvelib.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'\u00a8\u0006\u0005"}, d2 = {"Lfr/epf/min1/projetandroidvelib/api/StatusService;", "", "getStatus", "Lretrofit2/Call;", "Lcom/google/gson/JsonObject;", "app_debug"})
public abstract interface StatusService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/opendata/Velib_Metropole/station_status.json")
    public abstract retrofit2.Call<com.google.gson.JsonObject> getStatus();
}