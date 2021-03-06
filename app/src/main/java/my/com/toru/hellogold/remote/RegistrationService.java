package my.com.toru.hellogold.remote;

import my.com.toru.hellogold.model.request.Registration;
import my.com.toru.hellogold.model.response.RegisterResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface RegistrationService {
    @POST
    Call<RegisterResponse> getRegistration(@Url String url,
                                           @Body Registration reg);
}