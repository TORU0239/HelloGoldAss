package my.com.toru.hellogold.ui;

import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import my.com.toru.hellogold.model.request.Registration;
import my.com.toru.hellogold.model.response.RegisterResponse;
import my.com.toru.hellogold.remote.RetrofitInitializer;
import my.com.toru.hellogold.util.PreferenceUtil;
import my.com.toru.hellogold.util.Util;

public class RegisterViewModel {

    public Registration registration;

    public RegisterViewModel(){
        registration = new Registration();
    }

    public void register(final View v){
        if(isRegistrationValid()){
            if(Util.checkNetworkStatus(v.getContext())){
                registration.setUuid(Util.generateUUID());
                registration.setData(Util.generateRandom());

                if(registration.getTnc().equals("false")){
                    Toast.makeText(v.getContext(), "Please check that TNC to agree with our policy.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Log.w("VM", registration.toString());

                RetrofitInitializer.getinstance().createRegister(registration, new RetrofitInitializer.OnCallback<RegisterResponse>() {
                    @Override
                    public void onReturn(RegisterResponse body) {
                        switch (body.getResult()){
                            case "ok":
                                PreferenceUtil.getInstance().putString("EMAIL_ADDRESS", registration.getEmail());
                                PreferenceUtil.getInstance().putString("API_TOKEN", body.getData().getApiToken());
                                PreferenceUtil.getInstance().putString("PUBLIC_KEY", body.getData().getPublicKey());
                                PreferenceUtil.getInstance().putString("ACCOUNT_NUMBER", body.getData().getAccountNumber());
                                break;

                            case "error":
                                break;

                            default:
                                break;
                        }
                    }

                    @Override
                    public void onNeedCheck(RegisterResponse body) {}

                    @Override
                    public void onFailed() {
                        Toast.makeText(v.getContext(), "Please check your network status.", Toast.LENGTH_SHORT).show();
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