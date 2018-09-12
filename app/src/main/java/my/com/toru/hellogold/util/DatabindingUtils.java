package my.com.toru.hellogold.util;

import android.databinding.BindingAdapter;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import my.com.toru.hellogold.ui.MainSpotPriceAdapter;

public class DatabindingUtils {

    @BindingAdapter("colorScheme")
    public static void setColorSchemes(SwipeRefreshLayout layout, boolean isSet){
        if(isSet){
            layout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
            );
        }
    }

    @BindingAdapter("initLayout")
    public static void setInitLayout(RecyclerView recyclerView, boolean isCustom){
        if(isCustom){
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        }
    }

    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView recyclerView, MainSpotPriceAdapter adapter){
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("emailAddress")
    public static void setEmailAddress(Toolbar toolbar, String email){
        toolbar.setTitle(email);
    }
}
