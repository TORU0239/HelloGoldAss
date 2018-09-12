package my.com.toru.hellogold.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import my.com.toru.hellogold.remote.RetrofitInitializer;
import my.com.toru.hellogold.util.PreferenceUtil;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

public class InitRouterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        routing();
    }

    private void routing(){
        Intent intent = new Intent(InitRouterActivity.this, MainActivity.class);
        if(!PreferenceUtil.getInstance().getString(PreferenceUtil.EMAIL_ADDRESS, "").equals("")){
            intent = new Intent(InitRouterActivity.this, RegisterActivity.class);
        }

        // test code
        RetrofitInitializer.getinstance().createSpotPrice(new RetrofitInitializer.OnCallback<ResponseBody>() {
            @Override
            public void onReturn(ResponseBody body) {

            }

            @Override
            public void onNeedCheck(ResponseBody body) {

            }

            @Override
            public void onFailed() {

            }
        });

        startActivity(intent);
        finish();
    }
}
