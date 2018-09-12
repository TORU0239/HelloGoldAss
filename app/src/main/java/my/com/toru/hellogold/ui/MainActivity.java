package my.com.toru.hellogold.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.List;

import my.com.toru.hellogold.R;
import my.com.toru.hellogold.database.AppDatabase;
import my.com.toru.hellogold.model.response.Data;
import my.com.toru.hellogold.model.response.SpotPrice;
import my.com.toru.hellogold.remote.RetrofitInitializer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final SwipeRefreshLayout swipeRefresh = findViewById(R.id.swipe_main);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                List<Data> dataList = AppDatabase.getAppDatabase(MainActivity.this).dataDao().getAll();
                Log.w("InitRouter", "==============================");
                for(Data data : dataList){
                    Log.w("InitRouter", "data:: " + data.toString());
                }
                Log.w("InitRouter", "==============================");

                RetrofitInitializer.getinstance().createSpotPrice(new RetrofitInitializer.OnCallback<SpotPrice>() {
                    @Override
                    public void onReturn(SpotPrice body) {
                        AppDatabase.getAppDatabase(MainActivity.this).dataDao().insertEachData(body.getData());
                        swipeRefresh.setRefreshing(false);
                    }

                    @Override
                    public void onNeedCheck(SpotPrice body) {
                        swipeRefresh.setRefreshing(false);
                    }

                    @Override
                    public void onFailed() {
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        });

        swipeRefresh.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Data> dataList = AppDatabase.getAppDatabase(MainActivity.this).dataDao().getAll();
                Log.w("InitRouter", "==============================");
                for(Data data : dataList){
                    Log.w("InitRouter", "data:: " + data.toString());
                }
                Log.w("InitRouter", "==============================");

                RetrofitInitializer.getinstance().createSpotPrice(new RetrofitInitializer.OnCallback<SpotPrice>() {
                    @Override
                    public void onReturn(SpotPrice body) {
                        AppDatabase.getAppDatabase(MainActivity.this).dataDao().insertEachData(body.getData());
                        swipeRefresh.setRefreshing(false);
                    }

                    @Override
                    public void onNeedCheck(SpotPrice body) {
                        swipeRefresh.setRefreshing(false);
                    }

                    @Override
                    public void onFailed() {
                        swipeRefresh.setRefreshing(false);
                    }
                });
                swipeRefresh.setRefreshing(true);
            }
        });
    }
}
