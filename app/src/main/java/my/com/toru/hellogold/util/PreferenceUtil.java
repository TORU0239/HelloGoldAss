package my.com.toru.hellogold.util;

import android.content.Context;
import android.content.SharedPreferences;

import my.com.toru.hellogold.app.HelloGoldApp;

public class PreferenceUtil {
    private static final String PREFERENCE_NAME = "HELLOGOLD_PREFERENCE";

    public static final String EMAIL_ADDRESS = "EMAIL_ADDRESS";
    public static final String API_TOKEN = "API_TOKEN";
    public static final String PUBLIC_KEY = "PUBLIC_KEY";
    public static final String ACCOUNT_NUMBER = "ACCOUNT_NUMBER";

    private static PreferenceUtil util;

    private SharedPreferences preferences;

    public static PreferenceUtil getInstance(){
        if(util == null){
            util = new PreferenceUtil();
        }
        return util;
    }
    private PreferenceUtil() {
        preferences = HelloGoldApp.getApp().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public void clear() {
        SharedPreferences p = preferences;
        p.edit().clear().apply();
    }

    public String getString(String key, String defValue){
        SharedPreferences p = preferences;
        return p.getString(key, defValue);
    }

    public void putString(String key, String value){
        SharedPreferences p = preferences;
        SharedPreferences.Editor editor = p.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public boolean getBoolean(String key, boolean defValue){
        SharedPreferences p = preferences;
        return p.getBoolean(key, defValue);
    }

    public void putBoolean(String key, boolean value){
        SharedPreferences p = preferences;
        SharedPreferences.Editor editor = p.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public int getInteger(String key, int defValue){
        SharedPreferences p = preferences;
        return p.getInt(key, defValue);
    }

    public void putInteger(String key, int value){
        SharedPreferences p = preferences;
        SharedPreferences.Editor editor = p.edit();
        editor.putInt(key, value);
        editor.apply();
    }
}