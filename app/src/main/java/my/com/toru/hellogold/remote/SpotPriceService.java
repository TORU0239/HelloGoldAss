package my.com.toru.hellogold.remote;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SpotPriceService {
    @GET("v2/spot_price.json")
    Call<ResponseBody> getSpotPrice();
}
