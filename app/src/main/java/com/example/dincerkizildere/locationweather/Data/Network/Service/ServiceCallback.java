package com.example.dincerkizildere.locationweather.Data.Network.Service;

public interface ServiceCallback<T> {

    void onResponse(T response);

    void onError(String message);
}
