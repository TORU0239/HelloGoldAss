package my.com.toru.hellogold.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import my.com.toru.hellogold.util.PreferenceUtil;

public class InitRouterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        routing();
    }

    private void routing(){
        Intent intent = new Intent(InitRouterActivity.this, MainActivity.class);
        if(!PreferenceUtil.
                getInstance()
                .getString(PreferenceUtil.EMAIL_ADDRESS, "").equals("")){
            intent = new Intent(InitRouterActivity.this, RegisterActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
