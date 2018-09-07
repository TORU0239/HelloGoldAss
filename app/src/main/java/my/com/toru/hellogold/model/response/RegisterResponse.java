package my.com.toru.hellogold.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class RegisterResponse {

    private String result;
    private RegisterData data;
    private String code;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public RegisterData getData() {
        return data;
    }

    public void setData(RegisterData data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegisterResponse)) return false;
        RegisterResponse that = (RegisterResponse) o;
        return Objects.equals(getResult(), that.getResult()) &&
                Objects.equals(getData(), that.getData()) &&
                Objects.equals(getCode(), that.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResult(), getData(), getCode());
    }

    @Override
    public String toString() {
        return "RegisterResponse{" +
                "result='" + result + '\'' +
                ", data=" + data.toString() +
                ", code='" + code + '\'' +
                '}';
    }

    public static class RegisterData{
        @SerializedName("api_token")
        private String apiToken;

        @SerializedName("public_key")
        private String publicKey;

        @SerializedName("account_number")
        private String accountNumber;

        public String getApiToken() {
            return apiToken;
        }

        public void setApiToken(String apiToken) {
            this.apiToken = apiToken;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public void setPublicKey(String publicKey) {
            this.publicKey = publicKey;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof RegisterData)) return false;
            RegisterData that = (RegisterData) o;
            return Objects.equals(getApiToken(), that.getApiToken()) &&
                    Objects.equals(getPublicKey(), that.getPublicKey()) &&
                    Objects.equals(getAccountNumber(), that.getAccountNumber());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getApiToken(), getPublicKey(), getAccountNumber());
        }

        @Override
        public String toString() {
            return "RegisterData{" +
                    "apiToken='" + apiToken + '\'' +
                    ", publicKey='" + publicKey + '\'' +
                    ", accountNumber='" + accountNumber + '\'' +
                    '}';
        }
    }
}
