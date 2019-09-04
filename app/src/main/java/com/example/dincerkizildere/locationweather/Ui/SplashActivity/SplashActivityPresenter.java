package com.example.dincerkizildere.locationweather.Ui.SplashActivity;

import android.app.Activity;
import android.content.Context;

import com.example.dincerkizildere.locationweather.Data.DataManager;
import com.example.dincerkizildere.locationweather.Ui.Base.BasePresenter;

public class SplashActivityPresenter<V extends SplashActivityMvpView> extends BasePresenter<V> implements SplashActivityMvpPresenter<V> {

    Activity activity;
    private Context context;
    DataManager dataManager;




    public SplashActivityPresenter(Activity activity, Context context, DataManager dataManager) {
        super(activity);
        this.activity=activity;
        this.context=context;
        this.dataManager=dataManager;
    }

    @Override
    public void startApplication() {
        getMvpView().openHomeActivity();
        getMvpView().killActivity();
    }
}
