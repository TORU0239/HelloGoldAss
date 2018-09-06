package my.com.toru.hellogold.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import my.com.toru.hellogold.R;
import my.com.toru.hellogold.databinding.ActivityRegisterBinding;
import my.com.toru.hellogold.model.request.Registration;
import my.com.toru.hellogold.util.Util;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        binding.setRegViewModel(new RegisterViewModel());
    }
}