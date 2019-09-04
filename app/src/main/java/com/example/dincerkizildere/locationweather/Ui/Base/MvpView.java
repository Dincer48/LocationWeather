package com.example.dincerkizildere.locationweather.Ui.Base;

public interface MvpView {
    void showMessageToast(String text);
    void showError(String text);
    void killActivity();
}
