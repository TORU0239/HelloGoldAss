package my.com.toru.hellogold.remote;

import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import my.com.toru.hellogold.BuildConfig;
import my.com.toru.hellogold.model.request.Registration;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitInitializer {
    private static final String TAG = RetrofitInitializer.class.getSimpleName();
    private static final int CONNECTION_TIMEOUT = 5000;
    private static final int READ_TIMEOUT = 5000;
    private static final int WRITE_TIMEOUT = 5000;
    private static final String BASE_URL = "https://staging.hellogold.com/api/";

    private static RetrofitInitializer initializer;

    private Retrofit retrofit;

    private RetrofitInitializer() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS);

        // Logging is only available in debug mode.
        if(BuildConfig.DEBUG) {
            builder.addInterceptor(loggingInterceptor);
        }
        OkHttpClient client = builder.build();

        retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
    }

    public static RetrofitInitializer getinstance(){
        if(initializer == null){
            initializer = new RetrofitInitializer();
        }
        return initializer;
    }

    public void createRegister(@NonNull Registration registration, @NonNull final OnCallback callback){
        retrofit.create(RegistrationService.class).getRegistration("v3/users/register.json", registration)
                .enqueue(new RetryCallback<ResponseBody>() {
                    @Override
                    public void onReturnSuccessResponse(ResponseBody body) {
                        callback.onReturn();
                    }

                    @Override
                    public void onFailureResponse() {
                        callback.onFailed();
                    }
                });
    }

    public interface OnCallback{
        void onReturn();
        void onFailed();
    }
}