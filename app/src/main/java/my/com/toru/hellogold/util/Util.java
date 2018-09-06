package my.com.toru.hellogold.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Patterns;

import java.util.Random;
import java.util.UUID;

public class Util {
    public static boolean checkNetworkStatus(Context ctx){
        ConnectivityManager connectivityManager = (ConnectivityManager) (ctx.getSystemService(Context.CONNECTIVITY_SERVICE));
        if(connectivityManager == null) {
            return false;
        }
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        return info != null && info.isConnectedOrConnecting();
    }

    public static boolean isEmailFormat(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static String generateUUID(){
        return UUID.randomUUID().toString();
    }

    public static String generateRandom(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 64;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}