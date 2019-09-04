package com.example.dincerkizildere.locationweather.Ui.Base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity implements MvpView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }


    @Override
    public void showMessageToast(String text) {
        Toast.makeText(this, text , Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showError(String text) {
        Toast.makeText(this, text , Toast.LENGTH_SHORT).show();

    }

    @Override
    public void killActivity() {
        this.finish();

    }
}
