package my.com.toru.hellogold.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import my.com.toru.hellogold.R;
import my.com.toru.hellogold.model.response.Data;

public class MainSpotPriceAdapter extends RecyclerView.Adapter<MainSpotPriceAdapter.MainSpotPriceVH> {

    @NonNull
    private List<Data> goldDataList;

    @NonNull
    public List<Data> getGoldDataList() {
        return goldDataList;
    }

    public void setGoldDataList(@NonNull List<Data> goldDataList) {
        this.goldDataList = goldDataList;
    }

    @NonNull
    @Override
    public MainSpotPriceVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_spot_price, parent, false);
        return new MainSpotPriceVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainSpotPriceVH holder, int position) {
        holder.bindData(goldDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return goldDataList.size();
    }

    static class MainSpotPriceVH extends RecyclerView.ViewHolder{

        TextView buyText, sellText, spotText, timeStampTxt;


        public MainSpotPriceVH(View itemView) {
            super(itemView);
            buyText = itemView.findViewById(R.id.gold_buy_txt);
            sellText = itemView.findViewById(R.id.gold_sell_txt);
            spotText = itemView.findViewById(R.id.gold_spot_price_txt);
            timeStampTxt = itemView.findViewById(R.id.timestamp_txt);
        }

        protected void bindData(Data data){
            buyText.setText(String.valueOf(data.getBuy()));
            sellText.setText(String.valueOf(data.getSell()));
            spotText.setText(String.valueOf(data.getSpotPrice()));
            timeStampTxt.setText(data.getTimestamp());
        }
    }
}