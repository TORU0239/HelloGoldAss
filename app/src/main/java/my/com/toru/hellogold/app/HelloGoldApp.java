package my.com.toru.hellogold.app;

import android.app.Application;

public class HelloGoldApp extends Application {

    private static HelloGoldApp app;

    public static HelloGoldApp getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}