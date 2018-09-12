package my.com.toru.hellogold.model.response;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class SpotPrice {
    private String result;

    private Data data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpotPrice)) return false;
        SpotPrice spotPrice = (SpotPrice) o;
        return Objects.equals(getResult(), spotPrice.getResult()) &&
                Objects.equals(getData(), spotPrice.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResult(), getData());
    }

    @Override
    public String toString() {
        return "SpotPrice{" +
                "result='" + result + '\'' +
                ", data=" + data +
                '}';
    }
}
