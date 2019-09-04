package com.example.dincerkizildere.locationweather.Ui.SettingsActivity;

import android.app.Activity;
import android.content.Context;

import com.example.dincerkizildere.locationweather.Data.DataManager;
import com.example.dincerkizildere.locationweather.Ui.Base.BasePresenter;

import javax.inject.Inject;

public class SettingsActivityPresenter<V extends  SettingsActivityMvpView> extends BasePresenter<V> implements SettingsActivityMvpPresenter<V> {

    Activity activity;
    private Context context;


    @Inject
    DataManager dataManager;


    public SettingsActivityPresenter(Activity activity, Context context, DataManager dataManager) {
        super(activity);
        this.activity=activity;
        this.context=context;
        this.dataManager=dataManager;
    }

    @Override
    public void getCurrentLocation() {

    }
}
