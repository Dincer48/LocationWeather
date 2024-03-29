package com.example.dincerkizildere.locationweather.Ui.CitiesActivity;

import android.app.Activity;
import android.content.Context;

import com.example.dincerkizildere.locationweather.Data.DataManager;
import com.example.dincerkizildere.locationweather.Ui.Base.BasePresenter;

import javax.inject.Inject;

public class CitiesActivityPresenter<V extends CitiesActivityMvpView> extends BasePresenter<V> implements CitiesActivityMvpPresenter<V> {

    Activity activity;
    private Context context;

    @Inject
    DataManager dataManager;

    public CitiesActivityPresenter(Activity activity, Context context, DataManager dataManager){
        super(activity);
        this.dataManager=dataManager;
        this.activity=activity;
        this.context=context;
    }
}
