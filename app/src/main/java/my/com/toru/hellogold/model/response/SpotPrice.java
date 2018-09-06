package my.com.toru.hellogold.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class SpotPrice {
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

    private String result;
    private Data data;

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

    private static class Data{
        private Double buy;
        private Double sell;
        @SerializedName("spot_price")
        private Double spotPrice;
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
}
