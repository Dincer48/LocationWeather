package com.example.dincerkizildere.locationweather.Ui.CitiesActivity;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.dincerkizildere.locationweather.Data.DataManager;
import com.example.dincerkizildere.locationweather.Di.DaggerApplication;
import com.example.dincerkizildere.locationweather.R;
import com.example.dincerkizildere.locationweather.Ui.Adapters.CitiesAdapter;
import com.example.dincerkizildere.locationweather.Ui.Adapters.ItemClickListener;
import com.example.dincerkizildere.locationweather.Ui.Base.BaseActivity;
import com.example.dincerkizildere.locationweather.Ui.HomeActivity.HomeActivity;
import com.example.dincerkizildere.locationweather.Utility.Utils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CitiesActivity extends BaseActivity implements CitiesActivityMvpView {

    CitiesActivityPresenter<CitiesActivityMvpView> presenter;

    @Inject
    DataManager dataManager;

    List<String> citiesList;
    List<String> checkedCityList;
    int checkedC;

    @BindView(R.id.recyclerViewCities)
    RecyclerView recyclerViewCities;



    Toolbar toolbarCities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
        ButterKnife.bind(this);
        ((DaggerApplication) getApplication()).getDaggerComponent().inject(this);
        presenter = new CitiesActivityPresenter(CitiesActivity.this, getApplication(), dataManager);
        loadToolbar();
        loadCities();
    }


    @Override
    public void loadCities() {


        checkedCityList = new ArrayList<>();
        getCities();
        recyclerViewCities.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        if(dataManager.getCheckedCityList() != null) {
            checkedCityList = dataManager.getCheckedCityList();
        }
        else checkedCityList = new ArrayList<>();

        if (dataManager.getCheckedCityCount() > 0) {
            checkedC = dataManager.getCheckedCityCount();
        }
        else checkedC = 0;

        CitiesAdapter adapter = new CitiesAdapter(this, citiesList, checkedCityList, new ItemClickListener() {
                    @Override
                    public void CityItemClick(int position, String city, boolean isChecked, int checkedCount) {

                        if (isChecked)
                            checkedCityList.add(city);
                        else if(!isChecked)
                            checkedCityList.remove(city);
                        checkedC = checkedCount;
                    }
                }, checkedC);
        recyclerViewCities.setHasFixedSize(true);
        recyclerViewCities.setAdapter(adapter);



    }

    @Override
    public void loadToolbar() {
        toolbarCities = findViewById(R.id.toolbarCities);
        setSupportActionBar(toolbarCities);
        getSupportActionBar().setTitle("City List");
    }

    @Override
    public void getCities() {
        citiesList = new ArrayList<>();
        citiesList.add("Muğla");
        citiesList.add("Istanbul");
        citiesList.add("Adana");
        citiesList.add("Karaman");
        citiesList.add("Manisa");
        citiesList.add("Isparta");
        citiesList.add("Konya");
        citiesList.add("Gaziantep");
        citiesList.add("Sakarya");
        citiesList.add("Denizli");
        citiesList.add("Bursa");
        citiesList.add("Malatya");
        citiesList.add("Tokat");
        citiesList.add("Kocaeli");
        citiesList.add("Bolu");
        citiesList.add("Edirne");
        citiesList.add("Trabzon");
        citiesList.add("Erzurum");
        citiesList.add("Antalya");
        citiesList.add("Mersin");
        citiesList.add("Burdur");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_cities, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                dataManager.saveCheckedCityCount(checkedC);
                dataManager.saveCheckedCityList(checkedCityList);
                Toast.makeText(this, "Changes have been saved.", Toast.LENGTH_SHORT).show();
                Utils.changeActivity(CitiesActivity.this, HomeActivity.class);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}