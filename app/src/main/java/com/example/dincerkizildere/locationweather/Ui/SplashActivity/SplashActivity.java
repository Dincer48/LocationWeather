package com.example.dincerkizildere.locationweather.Ui.SplashActivity;

import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.example.dincerkizildere.locationweather.Data.DataManager;
import com.example.dincerkizildere.locationweather.Di.DaggerApplication;
import com.example.dincerkizildere.locationweather.R;
import com.example.dincerkizildere.locationweather.Ui.Base.BaseActivity;
import com.example.dincerkizildere.locationweather.Ui.HomeActivity.HomeActivity;
import com.example.dincerkizildere.locationweather.Utility.Utils;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements SplashActivityMvpView {

    SplashActivityPresenter<SplashActivityMvpView> presenter;

    @Inject
    DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        loadSplash();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ((DaggerApplication) getApplication()).getDaggerComponent().inject(SplashActivity.this);
                presenter = new SplashActivityPresenter<>(SplashActivity.this, getApplication(), dataManager);
                presenter.startApplication();
            }
        },2000);


    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void openHomeActivity() {
        Utils.changeActivity(this, HomeActivity.class);
    }

    @Override
    public void loadSplash() {
        ImageView imageBackground = findViewById(R.id.imageBackground);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        WindowManager wManager = window.getWindowManager();
        Display display = wManager.getDefaultDisplay();

        Point point = new Point();
        display.getSize(point);

        int width = point.x;
        int height = point.y;
        float multipler = 1.5116f;
        imageBackground.getLayoutParams().width = (int) (height*multipler);
        imageBackground.getLayoutParams().height = height;

        ObjectAnimator animator = ObjectAnimator.ofFloat(imageBackground, "x", 0, -(height*multipler-width), 0, -(height*multipler-width));
        animator.setDuration(120000);
        animator.setInterpolator(new LinearInterpolator());
        animator.start();
    }
}