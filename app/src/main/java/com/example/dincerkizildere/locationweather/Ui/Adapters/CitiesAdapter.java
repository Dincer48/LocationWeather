package com.example.dincerkizildere.locationweather.Ui.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.dincerkizildere.locationweather.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.annotations.NonNull;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.MyViewHolder> {

    Context context;
    List<String> citiesList;
    List<String> checkedList;
    ItemClickListener clickListener;
    int checkedCount;

    public CitiesAdapter(Context context, List<String> citiesList,List<String> chechkedList,ItemClickListener clickListener,int checkedCount){
        this.context=context;
        this.citiesList=citiesList;
        this.checkedList=chechkedList;
        this.clickListener=clickListener;
        this.checkedCount=checkedCount;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_cities, parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.checkBoxCity.setText(citiesList.get(position));

        for (String city:checkedList){
            if (holder.checkBoxCity.getText().equals(city)){
                holder.checkBoxCity.setChecked(true);
            }
        }

        holder.checkBoxCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.checkBoxCity.isChecked()){
                    checkedCount++;
                }
                else if (!holder.checkBoxCity.isChecked()){
                    if (checkedCount <= 1){
                        Toast.makeText(context,"En az bir şehir seçili kalmalı.", Toast.LENGTH_SHORT).show();
                        holder.checkBoxCity.setChecked(true);
                    }
                    else
                        checkedCount--;
                }
                clickListener.CityItemClick(position,String.valueOf(holder.checkBoxCity.getText()), holder.checkBoxCity.isChecked(), checkedCount);
            }
        });

    }

    @Override
    public int getItemCount() {
        return citiesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBoxCity;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBoxCity=itemView.findViewById(R.id.checkBoxCity);
        }
    }
}
