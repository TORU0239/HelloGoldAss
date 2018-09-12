package my.com.toru.hellogold.ui;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import java.util.List;

import my.com.toru.hellogold.app.HelloGoldApp;
import my.com.toru.hellogold.database.AppDatabase;
import my.com.toru.hellogold.model.response.Data;
import my.com.toru.hellogold.model.response.SpotPrice;
import my.com.toru.hellogold.remote.RetrofitInitializer;
import my.com.toru.hellogold.util.PreferenceUtil;


public class MainViewModel {
    public ObservableField<String> toolbarEmail = new ObservableField<>();
    public ObservableBoolean isRefreshing = new ObservableBoolean();
    public ObservableBoolean isSwipeColorSet = new ObservableBoolean(true);
    public ObservableBoolean isRecyclerViewCustom = new ObservableBoolean(true);

    public MainSpotPriceAdapter adapter;


    // handling fab click event
    public void onClickFetchData(View view){
        onStartFetchData();
        RetrofitInitializer.getinstance().createSpotPrice(new RetrofitInitializer.OnCallback<SpotPrice>() {
            @Override
            public void onReturn(SpotPrice body) {
                onSuccessFetchData(body);
            }

            @Override
            public void onNeedCheck(SpotPrice body) {
                onNeedCheckData();
            }

            @Override
            public void onFailed() {
                onErrorData();
            }
        });
    }

    public MainViewModel() {
        adapter = new MainSpotPriceAdapter();
        List<Data> dataList = AppDatabase.getAppDatabase(HelloGoldApp.getApp().getApplicationContext()).dataDao().getAll();
        adapter.setGoldDataList(dataList);
        adapter.notifyDataSetChanged();
        toolbarEmail.set(PreferenceUtil.getInstance().getString(PreferenceUtil.EMAIL_ADDRESS, ""));
        onFetchData();
    }

    public SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            onFetchData();
        }
    };

    private void onFetchData(){
        onStartFetchData();
        RetrofitInitializer.getinstance().createSpotPrice(new RetrofitInitializer.OnCallback<SpotPrice>() {
            @Override
            public void onReturn(SpotPrice body) {
                onSuccessFetchData(body);
            }

            @Override
            public void onNeedCheck(SpotPrice body) {
                onNeedCheckData();
            }

            @Override
            public void onFailed() {
                onErrorData();
            }
        });
    }

    private void onStartFetchData(){
        isRefreshing.set(true);
    }

    private void onSuccessFetchData(SpotPrice body){
        isRefreshing.set(false);
        AppDatabase.getAppDatabase(HelloGoldApp.getApp().getApplicationContext()).dataDao().insertEachData(body.getData());
        adapter.getGoldDataList().add(0, body.getData());
        adapter.notifyDataSetChanged();
    }

    private void onNeedCheckData(){
        isRefreshing.set(false);
    }

    private void onErrorData(){
        isRefreshing.set(false);
    }
}