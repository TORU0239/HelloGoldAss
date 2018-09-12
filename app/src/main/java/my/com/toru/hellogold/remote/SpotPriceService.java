package my.com.toru.hellogold.remote;

import my.com.toru.hellogold.model.response.SpotPrice;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SpotPriceService {
    String URL_SPOT_PRICE = "v2/spot_price.json";
    @GET(URL_SPOT_PRICE)
    Call<SpotPrice> getSpotPrice();
}
