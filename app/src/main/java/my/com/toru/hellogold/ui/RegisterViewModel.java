package my.com.toru.hellogold.ui;

import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import my.com.toru.hellogold.model.request.Registration;
import my.com.toru.hellogold.remote.RetrofitInitializer;
import my.com.toru.hellogold.util.Util;

public class RegisterViewModel {

    public Registration registration;

    public RegisterViewModel(){
        registration = new Registration();
    }

    public void register(View v){
        Log.w("VM", registration.toString());
        if(isRegistrationValid()){
            if(Util.checkNetworkStatus(v.getContext())){
                registration.setUuid(Util.generateUUID());
                registration.setData(Util.generateRandom());
                RetrofitInitializer.getinstance().createRegister(registration, new RetrofitInitializer.OnCallback() {
                    @Override
                    public void onReturn() {

                    }

                    @Override
                    public void onFailed() {

                    }
                });
            }
            else{
                Toast.makeText(v.getContext(), "Please check network status!!", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(v.getContext(), "Invalid Information!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isRegistrationValid(){
        return Util.isEmailFormat(registration.getEmail());
    }

    public CompoundButton.OnCheckedChangeListener tncCheckListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String checked = "false";
            if(isChecked){
                checked = "true";
            }
            registration.setTnc(checked);
        }
    };
}