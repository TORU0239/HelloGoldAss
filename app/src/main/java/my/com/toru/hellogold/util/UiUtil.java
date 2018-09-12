package my.com.toru.hellogold.util;

import android.databinding.BindingAdapter;
import android.support.v4.widget.SwipeRefreshLayout;

public class UiUtil {
    @BindingAdapter("refresh_color")
    public static void setRefreshColor(SwipeRefreshLayout refreshLayout, boolean isSet){
        if(isSet){
            refreshLayout.setColorSchemeResources(
                    android.R.color.holo_blue_bright,
                    android.R.color.holo_green_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_red_light
            );
        }
    }
}
