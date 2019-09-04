package com.example.dincerkizildere.locationweather.Ui.SettingsActivity;

import android.location.Location;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.dincerkizildere.locationweather.Data.DataManager;
import com.example.dincerkizildere.locationweather.Di.DaggerApplication;
import com.example.dincerkizildere.locationweather.Eventbus.LocationEvent;
import com.example.dincerkizildere.locationweather.R;
import com.example.dincerkizildere.locationweather.Ui.Base.BaseActivity;
import com.example.dincerkizildere.locationweather.Ui.HomeActivity.HomeActivity;
import com.example.dincerkizildere.locationweather.Utility.ProvideLocation;
import com.example.dincerkizildere.locationweather.Utility.Utils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingsActivity extends BaseActivity implements SettingsActivityMvpView {

    SettingsActivityMvpPresenter<SettingsActivityMvpView> presenter;

    @BindView(R.id.switchLocation)
    Switch switcLocation;

    @Inject
    DataManager dataManager;

    Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        ((DaggerApplication)getApplication()). getDaggerComponent().inject(this);

        presenter=new SettingsActivityPresenter<>(SettingsActivity.this,getApplication(), dataManager);

        switchListener();


    }



    @Override
    public void switchListener() {

        String gpsState= dataManager.getGpsState();
        if (gpsState=="ON"){
            switcLocation.setChecked(true);
        }

        switcLocation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    ProvideLocation provideLocation=new ProvideLocation();
                    provideLocation.getLocation(SettingsActivity.this);
                    showMessageToast("GPS AÇIK");
                    dataManager.saveGpsState("ON");
                }
                else {
                    LocationEvent stickyEvent= EventBus.getDefault().getStickyEvent(LocationEvent.class);
                    if (stickyEvent!=null){
                        EventBus.getDefault().removeStickyEvent(stickyEvent);

                        showMessageToast("GPS KAPALI");
                        dataManager.saveGpsState("OFF");
                    }
                }
            }
        });

    }
    @Override
    protected void onStop(){
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onStart(){
        super.onStart();
        EventBus.getDefault().register(this);

        String gpsState= dataManager.getGpsState();
        if (gpsState=="ON"){
            switcLocation.setChecked(true);
        }
    }


    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void onEvent(LocationEvent locationEvent){
        location = locationEvent.getLocation();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        this.finish();
        Utils.changeActivity(this, HomeActivity.class);
    }
}
