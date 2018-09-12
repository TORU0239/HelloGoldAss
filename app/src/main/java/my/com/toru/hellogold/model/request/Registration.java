package my.com.toru.hellogold.model.request;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.Objects;

public class Registration extends BaseObservable{
    private String email = "";
    private String uuid = "";
    private String data = "";
    private String tnc = "false";

    public Registration(String email, String uuid, String data, String tnc) {
        this.email = email;
        this.uuid = uuid;
        this.data = data;
        this.tnc = tnc;
    }

    public Registration() {}

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Bindable
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Bindable
    public String getTnc() {
        return tnc;
    }

    public void setTnc(String tnc) {
        this.tnc = tnc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Registration)) return false;
        Registration that = (Registration) o;
        return Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getUuid(), that.getUuid()) &&
                Objects.equals(getData(), that.getData()) &&
                Objects.equals(getTnc(), that.getTnc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getUuid(), getData(), getTnc());
    }

    @Override
    public String toString() {
        return "Registration{" +
                "email='" + email + '\'' +
                ", uuid='" + uuid + '\'' +
                ", data='" + data + '\'' +
                ", tnc='" + tnc + '\'' +
                '}';
    }
}