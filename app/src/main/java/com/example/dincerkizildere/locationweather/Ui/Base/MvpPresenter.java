package com.example.dincerkizildere.locationweather.Ui.Base;

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);
    void onDetach();
}
