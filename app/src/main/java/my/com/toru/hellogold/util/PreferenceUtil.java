package my.com.toru.hellogold.util;

import android.content.Context;
import android.content.SharedPreferences;

import my.com.toru.hellogold.app.HelloGoldApp;

public class PreferenceUtil {
    private static final String PREFERENCE_NAME = "HELLOGOLD_PREFERENCE";

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

    public void getString(String key, String defValue){
        SharedPreferences p = preferences;
        p.getString(key, defValue);
        p.edit().apply();
    }

    public void putString(String key, String value){
        SharedPreferences p = preferences;
        SharedPreferences.Editor editor = p.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void getBoolean(String key, boolean defValue){
        SharedPreferences p = preferences;
        p.getBoolean(key, defValue);
        p.edit().apply();
    }

    public void putBoolean(String key, boolean value){
        SharedPreferences p = preferences;
        SharedPreferences.Editor editor = p.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void getInteger(String key, int defValue){
        SharedPreferences p = preferences;
        p.getInt(key, defValue);
        p.edit().apply();
    }

    public void putInteger(String key, int value){
        SharedPreferences p = preferences;
        SharedPreferences.Editor editor = p.edit();
        editor.putInt(key, value);
        editor.apply();
    }
}