package com.example.dincerkizildere.locationweather.Utility;

import android.app.Activity;
import android.content.Intent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static final String APP_ID="7b17afb1963e50596c62c27f7e772ed9";

    public static void changeActivity(Activity activity,Class<?> goClass){
        Intent intent=new Intent(activity,goClass);
        activity.startActivity(intent);
    }

    public static String convertUnixToDate(long dt){
        Date date=new Date(dt*1000L);
        SimpleDateFormat sdf= new SimpleDateFormat("HH:mm dd EEE MM yyy");
        String formatted=sdf.format(date);
        return formatted;
    }

    public static String convertUnixToHour(long dt){
        Date date=new Date(dt*1000L);
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm EEE MM yyy");
        String formatted=sdf.format(date);
        return formatted;
    }
}
