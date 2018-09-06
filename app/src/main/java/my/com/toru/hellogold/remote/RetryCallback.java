package my.com.toru.hellogold.remote;

import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RetryCallback<T> implements Callback<T> {
    private static final String TAG = RetryCallback.class.getSimpleName();
    private int callCount = 0;

    @Override
    public void onResponse(@NonNull Call<T> call,
                           @NonNull Response<T> response) {
        if(response.isSuccessful()){
            onReturnSuccessResponse(response.body());
        }
        else{
            if(callCount < 2){
                call.clone().enqueue(this);
                callCount += 1;
            }
            else{
                callCount = 0;
                onFailureResponse();
            }
        }
    }

    @Override
    public void onFailure(@NonNull Call<T> call,
                          @NonNull Throwable t) {
        if(callCount < 2){
            call.clone().enqueue(this);
            callCount += 1;
        }
        else{
            callCount = 0;
            t.printStackTrace();
            onFailureResponse();
        }
    }

    public abstract void onReturnSuccessResponse(T body);
    public abstract void onFailureResponse();
}