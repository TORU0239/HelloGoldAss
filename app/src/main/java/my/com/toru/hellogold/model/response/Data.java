package my.com.toru.hellogold.model.response;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

@Entity(tableName = "priceData")
public class Data{

    @ColumnInfo(name="buy")
    private Double buy;

    @ColumnInfo(name="sell")
    private Double sell;

    @SerializedName("spot_price")
    @ColumnInfo(name="spotPrice")
    private Double spotPrice;

    @NonNull
    @PrimaryKey()
    private String timestamp;

    public Double getBuy() {
        return buy;
    }

    public void setBuy(Double buy) {
        this.buy = buy;
    }

    public Double getSell() {
        return sell;
    }

    public void setSell(Double sell) {
        this.sell = sell;
    }

    public Double getSpotPrice() {
        return spotPrice;
    }

    public void setSpotPrice(Double spotPrice) {
        this.spotPrice = spotPrice;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;
        Data data = (Data) o;
        return Objects.equals(getBuy(), data.getBuy()) &&
                Objects.equals(getSell(), data.getSell()) &&
                Objects.equals(getSpotPrice(), data.getSpotPrice()) &&
                Objects.equals(getTimestamp(), data.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBuy(), getSell(), getSpotPrice(), getTimestamp());
    }

    @Override
    public String toString() {
        return "Data{" +
                "buy=" + buy +
                ", sell=" + sell +
                ", spotPrice=" + spotPrice +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
