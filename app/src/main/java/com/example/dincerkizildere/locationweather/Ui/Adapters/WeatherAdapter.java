package com.example.dincerkizildere.locationweather.Ui.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dincerkizildere.locationweather.Data.DataManager;
import com.example.dincerkizildere.locationweather.Data.Network.Model.WeatherResult;
import com.example.dincerkizildere.locationweather.Data.Network.Service.ServiceCallback;
import com.example.dincerkizildere.locationweather.R;
import com.example.dincerkizildere.locationweather.Utility.Utils;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.MyViewHolder> {

    Context context;
    List<String> cityList;
    WeatherResult response;

    @Inject
    DataManager dataManager;

    public WeatherAdapter(Context context, List<String> cityList, DataManager dataManager){
        this.context=context;
        this.cityList=cityList;
        this.dataManager=dataManager;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.item_weather, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        dataManager.weatherCityNameService(cityList.get(position), new ServiceCallback<WeatherResult>() {
            @Override
            public void onResponse(WeatherResult response) {
                Picasso.get().load(new StringBuilder("https://openweathermap.org/img/w/")
                .append(response.getWeather().get(0).getIcon())
                .append(".png").toString()).into(holder.imgWeather);

                holder.txtCityName.setText(response.getName());

                holder.txtDescription.setText(new StringBuilder(response.getName()).append("Hava Durumu Tahmini"));

                holder.txtTemperature.setText(new StringBuilder(String.valueOf(response.getMain().getTemp())).append(" hpa").toString());

                holder.txtHumidity.setText(new StringBuilder(String.valueOf(response.getMain().getHumidity())).append("%").toString());

                holder.txtSunrise.setText(Utils.convertUnixToHour(response.getSys().getSunrise()));
                holder.txtSunset.setText(Utils.convertUnixToHour(response.getSys().getSunset()));
                holder.txtWind.setText(new StringBuilder("Hız: ").append(response.getWind().getSpeed())
                .append(", Derece: ").append(response.getWind().getDeg()));
            }

            @Override
            public void onError(String message) {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtTemperature,txtCityName,txtDescription,txtDateTime,txtWind, txtPressure,txtHumidity,txtSunrise,txtSunset;
        ImageView imgWeather;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtCityName=itemView.findViewById(R.id.txtCityName2);
            txtDateTime=itemView.findViewById(R.id.txtCityDateTime2);
            txtDescription=itemView.findViewById(R.id.txtDescription2);
            txtHumidity=itemView.findViewById(R.id.txtHumidity2);
            txtPressure=itemView.findViewById(R.id.txtPressure2);
            txtSunrise=itemView.findViewById(R.id.txtSunrise2);
            txtSunset=itemView.findViewById(R.id.txtSunset2);
            txtTemperature=itemView.findViewById(R.id.txtCityTemperature2);
            txtWind=itemView.findViewById(R.id.txtWind2);

            imgWeather=itemView.findViewById(R.id.imgWeather2);

        }
    }
}
