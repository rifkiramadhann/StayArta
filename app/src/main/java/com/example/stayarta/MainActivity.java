package com.example.stayarta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.stayarta.adapter.HotelAdapter;
import com.example.stayarta.alarm.AlarmActivity;
import com.example.stayarta.model.HotelItem;
import com.example.stayarta.model.RootHotelModel;
import com.example.stayarta.rest.ApiConfig;
import com.example.stayarta.rest.ApiService;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private ArrayList<HotelItem> hotelItems;
    private HotelAdapter hotelAdapter;
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "com.example.staypur";
    private Text mAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        hotelItems = new ArrayList<>();
        getData();
        mPreferences = getSharedPreferences(sharedPrefFile,MODE_PRIVATE);
    }

    private void getData() {
        ApiService apiService = ApiConfig.getApiService();
        apiService.getData().enqueue(new Callback<RootHotelModel>() {
            @Override
            public void onResponse(Call<RootHotelModel> call, Response<RootHotelModel> response) {
                if (response.isSuccessful()) {
                    hotelItems = response.body().getHotel();
                    hotelAdapter = new HotelAdapter(hotelItems, getApplicationContext());
                    rv.setAdapter(hotelAdapter);
                    rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            }

            @Override
            public void onFailure(Call<RootHotelModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        rv = findViewById(R.id.rv);
        mAlarm= findViewById(R.id.alarm);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.alarm:
                Intent intent = new Intent(MainActivity.this, AlarmActivity.class);
                String mOrderMessage = null;
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
                return true;
            default:
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.apply();
    }

}